package cn.wan.sdutoa.service;

import cn.wan.sdutoa.vo.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 万洪基 on 2017/2/27.
 */
public interface OfficeService {

//    获奖详情管理
    public String getAwardList() throws Exception;

    public String addAward(VoAward voAward, CommonsMultipartFile file, HttpServletRequest request) throws Exception;

//    教研论文管理
    public String getTeachingPaperList() throws Exception;

    public String addTeachingPaper(VoTeachingPaper voTeachingPaper, HttpServletRequest request,CommonsMultipartFile file) throws Exception;

    public String updateTeachingPaperByUUID(VoTeachingPaper voTeachingPaper,HttpServletRequest request, CommonsMultipartFile file) throws Exception;

    public String deleteTeachingPaperByUUID(String uuid) throws Exception;

    public VoTeachingPaper getTeachingPaperByUUID(String uuid) throws Exception;

//    教研课题管理
    public String getTopicPaperList() throws Exception;

    public String addTopicPaper(VoTopicPaper voTopicPaper) throws Exception;

    public String updateTopicPaperByUUID(VoTopicPaper voTopicPaper) throws Exception;

    public String deleteTopicPaperByUUID(String uuid) throws Exception;

//    试卷归档管理
    public String getTestPaperList() throws Exception;

    public String addTestPaper(VoQuestionPaper voQuestionPaper) throws Exception;

    public String updateTestPaperById(VoQuestionPaper voQuestionPaper) throws Exception;

    public String deleteTestPaperById(int qid) throws Exception;

//    实训归档管理
    public String getTrainingPaperList() throws Exception;

    public String addTrainingPaper(VoTrainingPaper voTrainingPaper) throws Exception;

    public String updateTrainingPaperById(VoTrainingPaper voTrainingPaper) throws Exception;

    public String deleteTrainingPaperById(int tid) throws Exception;
}
