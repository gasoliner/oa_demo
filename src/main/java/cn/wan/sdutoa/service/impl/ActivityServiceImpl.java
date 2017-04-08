package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.OfficeMapper;
import cn.wan.sdutoa.po.AuditingInfo;
import cn.wan.sdutoa.service.ActivityService;
import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.VoAward;
import cn.wan.sdutoa.vo.VoProcessDefinition;
import cn.wan.sdutoa.vo.VoTask;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * Created by 万洪基 on 2017/3/27.
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    OfficeMapper officeMapper;
    @Autowired
    UserService userService;
    @Autowired
    HistoryService historyService;



    public String deployActivityByZip(InputStream inputStreamZip) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStreamZip);
            Deployment deployment = repositoryService.createDeployment()
                    .addZipInputStream(zipInputStream)
                    .deploy();
            return JSON.toJSONString("部署成功");
        }catch (Exception e){
            e.fillInStackTrace();
            return JSON.toJSONString("部署失败,请稍后再试");
        }

    }

    public String processList() {

        List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery()
                .orderByProcessDefinitionVersion()
                .desc()
                .list();
        List<VoProcessDefinition> voProcessDefinitionList = new ArrayList<VoProcessDefinition>();
        for (ProcessDefinition processDefinition:
                definitions){
            VoProcessDefinition voProcessDefinition = new VoProcessDefinition();
            voProcessDefinition.setKey(processDefinition.getKey());
            voProcessDefinition.setDeploymentId(processDefinition.getDeploymentId());
            voProcessDefinition.setDiagramResourceName(processDefinition.getDiagramResourceName());
            voProcessDefinition.setName(processDefinition.getName());
            voProcessDefinition.setResourceName(processDefinition.getResourceName());
            voProcessDefinition.setVersion(processDefinition.getVersion());
            voProcessDefinition.setAction(PageUtil.setVoProcessAction(voProcessDefinition.getDeploymentId(),voProcessDefinition.getDiagramResourceName().replaceAll("\\.png","")));
            voProcessDefinitionList.add(voProcessDefinition);
        }
        return JSON.toJSONString(voProcessDefinitionList);
    }

    public String deleteProcessByDeploymentId(String deploymentId) {
        try {
            repositoryService.deleteDeployment(deploymentId);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            e.fillInStackTrace();
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    public void showProcessPng(String deploymentId, String resourceName, HttpServletResponse response) {
        try {
            PageUtil.showImg(repositoryService.getResourceAsStream(deploymentId,resourceName),response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String startAwardProcess(Long aid) {
        VoAward voAward = officeMapper.selectAwardByAid(aid);
        String processDefinitionKey = voAward.getClass().getSimpleName();
        String businessKey = processDefinitionKey + "." + voAward.getAid().toString();
//        设置流程变量
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName",PageUtil.getUser().getUsername());
//        map.put("",);
//        map.put("",);
//        voAward.setState(1);
        try {
//            startProcess("imitateOA");
            ProcessInstance processInstance =runtimeService.startProcessInstanceByKey(processDefinitionKey,businessKey,map);
//            officeMapper.updateAwardState(voAward);
//            return JSON.toJSONString("开始申请成功，请耐心等待审核结果");
            String taskId = taskService.createTaskQuery()
                    .processInstanceId(processInstance.getProcessInstanceId())
                    .singleResult()
                    .getId();
            return taskId;
        } catch (Exception e) {
            e.printStackTrace();
//            return JSON.toJSONString("开始申请异常，请稍后再试");
            return null;
        }
    }

    /**
     *  显示taskList，直接用taskCandidateOrAssigned()方法获取当前可以办理的
     *  任务，并在便利查询结果的中通过判断Assignee为空的条件来判断是组任务，并加
     *  入签收按钮
     * */
    public String todoListTaskByAssignee(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateOrAssigned(assignee)
                .orderByTaskCreateTime().asc()
                .list();
        List<VoTask> voTasks = new ArrayList<VoTask>();
        if (tasks != null && tasks.size() > 0){
            for (Task task:
                    tasks){
                VoTask voTask = new VoTask();
                voTask.setId(task.getId());
                voTask.setApplyTime(task.getCreateTime());
                voTask.setOwner(task.getOwner());
                voTask.setProcessName(task.getProcessInstanceId());
                voTask.setCurrentActiviti(task.getName());
                if (task.getAssignee() == null || task.getAssignee().trim().equals("")){
                    voTask.setVoAction(
                            "<a href = \"#\" onclick=\"claimTask('"+task.getId()+"')\">签收</a>"
                    );
                }
                voTasks.add(voTask);
            }
        }
        return JSON.toJSONString(voTasks);
    }

    public List<AuditingInfo> getSequenceFlowName(String taskId) {
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        String processDefinitionId = task.getProcessDefinitionId();
        ProcessDefinitionEntity entity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();
        ActivityImpl activity = entity.findActivity(processInstance.getActivityId());
        List<PvmTransition> pvmTransitions = activity.getOutgoingTransitions();
        List<AuditingInfo> auditingInfos = new ArrayList<AuditingInfo>();
        for (PvmTransition pvmTransition:
                pvmTransitions){
            String name = (String) pvmTransition.getProperty("name");
            AuditingInfo auditingInfo = new AuditingInfo();
            if (name != null && !name.trim().equals("")){
                auditingInfo.setVoAuditOpinion(name);
                auditingInfos.add(auditingInfo);
            }else {
                auditingInfo.setVoAuditOpinion("默认提交");
                auditingInfos.add(auditingInfo);
            }
        }
        return auditingInfos;
    }

    public String getAwardIdByTaskId(String taskId) {
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();
        String businessKey = processInstance.getBusinessKey();
        return businessKey.split("\\.")[1];
    }

    public String completeAwardTaskByTaskIdForTeacher(String taskId) {
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            List<String> userNameList = userService.getUserNameHaveActiviti();
            String candidateUsers = "";
            for (String s:
                    userNameList){
                candidateUsers = candidateUsers + "," + s;
            }
            candidateUsers.replaceFirst(",","");
            map.put("candidateUsers",candidateUsers);
            taskService.complete(taskId,map);
            return JSON.toJSONString("完成任务");
        }catch (Exception e){
            return JSON.toJSONString("完成任务失败，请稍后再试");
        }
    }

    public String completeAwardTaskByTaskIdForAdmin(String state, String taskId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("state",state);
        try {
            taskService.complete(taskId,map);
            return JSON.toJSONString("完成任务");
        }catch (Exception e){
            return JSON.toJSONString("完成任务失败，请稍后再试");
        }
    }

    public String claimTask(String userName, String taskId) {
        taskService.claim(taskId,userName);
        return null;
    }

    public String getHistoryTask(String assignee) {
        List<HistoricTaskInstance> taskInstanceList =
                historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(assignee)
                .orderByTaskCreateTime().asc()
                .list();
        List<VoTask> voTaskList = new ArrayList<VoTask>();
        for (HistoricTaskInstance historicTaskInstance:
                taskInstanceList){
            VoTask voTask = new VoTask();
            voTask.setId(historicTaskInstance.getId());
            voTask.setAssignee(historicTaskInstance.getAssignee());
            voTask.setStartTime(historicTaskInstance.getStartTime());
            voTask.setEndTime(historicTaskInstance.getEndTime());
            voTask.setCurrentActiviti(historicTaskInstance.getName());
            voTask.setProcessName(historicTaskInstance.getProcessDefinitionId());
            voTaskList.add(voTask);
        }
        return JSON.toJSONString(voTaskList);
    }
}
