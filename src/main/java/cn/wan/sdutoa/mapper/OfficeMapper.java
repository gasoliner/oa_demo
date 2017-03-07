package cn.wan.sdutoa.mapper;

import cn.wan.sdutoa.vo.VoQuestionPaper;
import cn.wan.sdutoa.vo.VoTopicPaper;
import cn.wan.sdutoa.vo.VoTrainingPaper;

import java.util.List;

/**
 * Created by 万洪基 on 2017/2/27.
 */
public interface OfficeMapper {

//    教研课题管理
    List<VoTopicPaper> selectAllTopicPaper ();

    void insertTopicPaper (VoTopicPaper voTopicPaper);

    void updateTopicPaperByUUIDSelective (VoTopicPaper voTopicPaper);

    void deleteTopicPaperByUUID (String uuid);

//    试卷归档管理
    List<VoQuestionPaper> selectAllTestPaper ();

    void insertTestPaper (VoQuestionPaper voQuestionPaper);

    void updateTestPaperByIdSelective (VoQuestionPaper voQuestionPaper);

    void deleteTestPaperById (int qid);

//    实训归档管理
    List<VoTrainingPaper> selectAllTrainingPaper ();

    void insertTrainingPaper (VoTrainingPaper voTrainingPaper);

    void updateTrainingPaperByIdSelective (VoTrainingPaper voTrainingPaper);

    void deleteTrainingPaperById (int tid);
}
