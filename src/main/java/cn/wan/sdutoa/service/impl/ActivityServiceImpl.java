package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.OfficeMapper;
import cn.wan.sdutoa.service.ActivityService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.VoAward;
import cn.wan.sdutoa.vo.VoProcessDefinition;
import com.alibaba.fastjson.JSON;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
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
        System.out.println("前端页面显示definitions:\t"+voProcessDefinitionList);
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
        String businessKey = processDefinitionKey + "." + aid.toString();
//        设置流程变量
        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("",);
//        map.put("",);
//        map.put("",);
        voAward.setState(1);
        try {
//            startProcess("imitateOA");
            runtimeService.startProcessInstanceByKey(processDefinitionKey,businessKey,map);
            officeMapper.updateAwardState(voAward);
            return JSON.toJSONString("开始申请成功，请耐心等待审核结果");
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("开始申请异常，请稍后再试");
        }
    }
}
