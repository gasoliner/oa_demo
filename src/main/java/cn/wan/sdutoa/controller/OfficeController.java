package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.OfficeService;
import cn.wan.sdutoa.vo.VoQuestionPaper;
import cn.wan.sdutoa.vo.VoTopicPaper;
import cn.wan.sdutoa.vo.VoTrainingPaper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 万洪基 on 2017/2/27.
 */
@Controller
@RequestMapping(value = "/office",produces = {"application/json;charset=UTF-8"})
public class OfficeController {

    @Autowired
    OfficeService officeService;
//    教研课题管理
    @RequestMapping("/topicPaper/list")
    @ResponseBody
    public String topicPaperList() throws Exception {
        return officeService.getTopicPaperList();
    }
    @RequestMapping("/topicPaper/addition")
    @ResponseBody
    public String topicPaperAddition(VoTopicPaper voTopicPaper) throws Exception {
        System.out.println("Controller:\t"+voTopicPaper);
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
