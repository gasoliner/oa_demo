package cn.wan.sdutoa.service;

import cn.wan.sdutoa.vo.VoQuestionPaper;
import cn.wan.sdutoa.vo.VoTopicPaper;
import cn.wan.sdutoa.vo.VoTrainingPaper;

/**
 * Created by 万洪基 on 2017/2/27.
 */
public interface OfficeService {

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
