package cn.wan.sdutoa.service;

import cn.wan.sdutoa.po.AuditingInfo;
import cn.wan.sdutoa.vo.VoAward;
import org.activiti.engine.task.Task;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 万洪基 on 2017/3/27.
 */
public interface ActivityService {

    public String deployActivityByZip (InputStream inputStreamZip);

    public String processList();

    public String deleteProcessByDeploymentId(String deploymentId);

    public void showProcessPng(String deploymentId, String resourceName, HttpServletResponse response);

    public String startAwardProcess(Long aid);

    public String todoListTaskByAssignee(String assignee);

    public List<AuditingInfo> getSequenceFlowName(String taskId);

    public String getAwardIdByTaskId(String taskId);

    public String completeAwardTaskByTaskIdForTeacher(String taskId);

    public String completeAwardTaskByTaskIdForAdmin(String state,String taskId);

    public String claimTask(String userName,String taskId);

    public String getHistoryTask(String assignee);

}
