package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.po.AuditingInfo;
import cn.wan.sdutoa.service.ActivityService;
import cn.wan.sdutoa.service.OfficeService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.*;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 万洪基 on 2017/2/27.
 */
@Controller
@RequestMapping(value = "/office",produces = {"application/json;charset=UTF-8"})
public class OfficeController {

    @Autowired
    OfficeService officeService;
    @Autowired
    ActivityService activityService;

//    我的任务

    @RequestMapping("/myTask/claiming")
    @ResponseBody
    public String claimTask(String taskId){
        return activityService.claimTask(PageUtil.getUser().getUsername(),taskId);
    }

    @RequestMapping("/myTask/user_completion/{taskId}")
    @ResponseBody
    public String completeAwardTaskForUser(VoAward voAward,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request,@PathVariable String taskId){
        return officeService.completeAwardTaskByTaskIdForTeacher(voAward,file,request,taskId);
    }

    /**
     * 备注：
     *      此处在修改完赋予权限后应更改为subject.isPermitted("activiti:*");
     * */
    @RequiresRoles("1")
    @RequestMapping("/myTask/act_completion/{taskId}")
    @ResponseBody
    public String completeTask(AuditingInfo auditingInfo,@PathVariable String taskId){
        return officeService.completeAwardTaskByTaskIdForAdmin(auditingInfo, taskId);
    }

    @RequestMapping("/myTask/sequenceFlow/{taskId}")
    @ResponseBody
    public String getTaskSequenceFlow(@PathVariable String taskId){
        return JSON.toJSONString(activityService.getSequenceFlowName(taskId));
    }

    @RequestMapping("/myTask/todoTaskList")
    @ResponseBody
    public String todoTaskList() throws Exception{
        return activityService.todoListTaskByAssignee(PageUtil.getUser().getUsername());
    }

    @RequestMapping("/myTask/taskInfo/{taskId}")
    @ResponseBody
    public String getTaskInfo(@PathVariable String taskId){

        return officeService.getAwardDetail(taskId);
    }

    @RequestMapping("/myTask/hisTaskList")
    @ResponseBody
    public String getHistoryTask(){
        return activityService.getHistoryTask(PageUtil.getUser().getUsername());
    }

//    获奖详情管理
    @RequestMapping("/award/list")
    @ResponseBody
    public String awardList() throws Exception {
        return officeService.getAwardList();
    }

    @RequestMapping("/award/addition")
    @ResponseBody
    public String awardAddition(VoAward voAward, @RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        return officeService.addAward(voAward, file, request);
    }



//    @RequestMapping("/award/beginning")
//    @ResponseBody
//    public String awardBeginning(Long aid){
//        return activityService.startAwardProcess(aid);
//    }

//    教研论文管理
    @RequestMapping("/teachingPaper/list")
    @ResponseBody
    public String teachingPaperList() throws Exception{
        return officeService.getTeachingPaperList();
    }
    @RequestMapping("/teachingPaper/addition")
    @ResponseBody
    public String teachingPaperAddition(VoTeachingPaper voTeachingPaper,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request)throws Exception{
        return officeService.addTeachingPaper(voTeachingPaper,request,file);
    }
    @RequestMapping("/teachingPaper/updates/{uuid}")
    @ResponseBody
    public String teachingPaperUpdates(VoTeachingPaper voTeachingPaper, @RequestParam("file") CommonsMultipartFile file,@PathVariable String uuid,HttpServletRequest request)throws Exception{
        voTeachingPaper.setUuid(uuid);
        return officeService.updateTeachingPaperByUUID(voTeachingPaper,request,file) ;
    }
    @RequestMapping("/teachingPaper/deletion/{uuid}")
    @ResponseBody
    public String teachingPaperDeletion(@PathVariable String uuid ) throws Exception{
        return officeService.deleteTeachingPaperByUUID(uuid);
    }

    @RequestMapping("/teachingPaper/showTePaper/{uuid}")
    public void showTeachingPaper(@PathVariable String uuid , HttpServletResponse response) throws Exception{
        PageUtil.showImg(officeService.getTeachingPaperByUUID(uuid).getAnnex()
                ,response);
    }


//    教研课题管理
    @RequestMapping("/topicPaper/list")
    @ResponseBody
    public String topicPaperList() throws Exception {
        return officeService.getTopicPaperList();
    }
    @RequestMapping("/topicPaper/addition")
    @ResponseBody
    public String topicPaperAddition(VoTopicPaper voTopicPaper) throws Exception {
        return officeService.addTopicPaper(voTopicPaper);
    }
    @RequestMapping("/topicPaper/updates/{uuid}")
    @ResponseBody
    public String topicPaperUpdates(VoTopicPaper voTopicPaper,@PathVariable("uuid") String uuid) throws Exception {
        voTopicPaper.setUuid(uuid);
        return officeService.updateTopicPaperByUUID(voTopicPaper);
    }
    @RequestMapping("/topicPaper/deletion/{uuid}")
    @ResponseBody
    public String topicPaperDeletion(@PathVariable("uuid") String uuid) throws Exception {
        return officeService.deleteTopicPaperByUUID(uuid);
    }

    //    实训归档管理
    @RequestMapping("/trainingPaper/list")
    @ResponseBody
    public String trainingPaperList() throws Exception {
        return officeService.getTrainingPaperList();
    }
    @RequestMapping("/trainingPaper/addition")
    @ResponseBody
    public String trainingPaperAddition(VoTrainingPaper voTrainingPaper) throws Exception{
        return officeService.addTrainingPaper(voTrainingPaper);
    }
    @RequestMapping("/trainingPaper/updates/{tid}")
    @ResponseBody
    public String trainingPaperUpdates(VoTrainingPaper voTrainingPaper,@PathVariable("tid") Long id) throws Exception{
        voTrainingPaper.setTid(id);
        return officeService.updateTrainingPaperById(voTrainingPaper);
    }
    @RequestMapping(value = "/trainingPaper/deletion/{tid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String trainingPaperDeletion(@PathVariable("tid")int tid) throws Exception {
        return officeService.deleteTrainingPaperById(tid);
    }

//    试卷归档管理
    @RequestMapping("/testPaper/list")
    @ResponseBody
    public String testPaperList() throws Exception {
        return officeService.getTestPaperList();
    }
    @RequestMapping("/testPaper/addition")
    @ResponseBody
    public String testPaperAddition(VoQuestionPaper voQuestionPaper) throws Exception{
        return officeService.addTestPaper(voQuestionPaper);
    }
    @RequestMapping("/testPaper/updates/{qid}")
    @ResponseBody
    public String testPaperUpdates(VoQuestionPaper voQuestionPaper,@PathVariable("qid") Long id) throws Exception{
        voQuestionPaper.setQid(id);
        return officeService.updateTestPaperById(voQuestionPaper);
    }
    @RequestMapping(value = "/testPaper/deletion/{qid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testPaperDeletion(@PathVariable("qid")int qid) throws Exception {
        return officeService.deleteTestPaperById(qid);
    }



}
