package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.ActivityService;
import cn.wan.sdutoa.service.SystemService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.VoNotice;
import cn.wan.sdutoa.vo.VoSystemDDL;
import cn.wan.sdutoa.vo.VoTeachingPaper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

/**
 * Created by 万洪基 on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/system",produces = {"application/json;charset=UTF-8"})
public class SystemController {
    @Autowired
    SystemService systemService;
    @Autowired
    ActivityService activityService;

//    流程
    @RequiresRoles("1")
    @RequestMapping("/process/list")
    @ResponseBody
    public String processList(){
        return activityService.processList();
    }

    @RequiresRoles("1")
    @RequestMapping("/process/addition")
    @ResponseBody
    public String processAddition(@RequestParam("file") CommonsMultipartFile file)throws Exception{
        return activityService.deployActivityByZip(file.getInputStream());
    }

    @RequiresRoles("1")
    @RequestMapping("/process/deletion/{deploymentId}")
    @ResponseBody
    public String processDeletion(@PathVariable("deploymentId")String deploymentId){
        return activityService.deleteProcessByDeploymentId(deploymentId);
    }

    @RequiresRoles("1")
    @RequestMapping("/process/ProPng/{deploymentId}/{resourceName}")
    public void showProcessPng(@PathVariable String deploymentId ,@PathVariable String resourceName , HttpServletResponse response) throws Exception{
        activityService.showProcessPng(deploymentId,resourceName+".png",response);
    }

//    字典
    @RequiresRoles("1")
    @RequestMapping("/dictionary/list/{keyword}")
    @ResponseBody
    public String dictionaryList(@PathVariable String keyword) throws Exception {
        return systemService.dictionaryListByKeyword(keyword);
    }

    @RequiresRoles("1")
    @RequestMapping("/dictionary/addition")
    @ResponseBody
    public String dictionaryAddition(VoSystemDDL voSystemDDL) throws Exception {
        return systemService.addDictionary(voSystemDDL);
    }

    @RequiresRoles("1")
    @RequestMapping("/dictionary/updates/{uuid}")
    @ResponseBody
    public String dictionaryUpdates(@PathVariable String uuid, VoSystemDDL voSystemDDL) throws Exception {
        return systemService.updateDictionaryByUUID(uuid,voSystemDDL);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/dictionary/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String dictionaryDeletion(@PathVariable String uuid) throws Exception {
        return systemService.deleteDictionaryByUUID(uuid);
    }

    @RequestMapping("/notice/list")
    @ResponseBody
    public String noticeList() throws Exception {
        return systemService.noticeListAll();
    }

    @RequiresRoles("1")
    @RequestMapping("/notice/addition")
    @ResponseBody
    public String noticeAddition(VoNotice voNotice) throws Exception {
        return systemService.addNotice(voNotice);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/notice/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String noticeDeletion(@PathVariable String uuid) throws Exception {
        return systemService.deleteNoticeByUUID(uuid);
    }

    @RequestMapping("/notice/{uuid}")
    @ResponseBody
    public String noticeByUUID(@PathVariable String uuid) throws Exception {
        return systemService.noticeByUUID(uuid);
    }
}
