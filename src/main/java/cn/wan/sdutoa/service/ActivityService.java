package cn.wan.sdutoa.service;

import cn.wan.sdutoa.vo.VoAward;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * Created by 万洪基 on 2017/3/27.
 */
public interface ActivityService {

    public String deployActivityByZip (InputStream inputStreamZip);

    public String processList();

    public String deleteProcessByDeploymentId(String deploymentId);

    public void showProcessPng(String deploymentId, String resourceName, HttpServletResponse response);

    public void startAwardProcess(Long aid);

    public String todoListTaskByAssignee(String assignee);

}
