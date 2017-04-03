package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.OfficeMapper;
import cn.wan.sdutoa.service.ActivityService;
import cn.wan.sdutoa.service.OfficeService;
import cn.wan.sdutoa.service.PublicService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by 万洪基 on 2017/2/27.
 * 申请的业务逻辑
 */
@Service("officeService")
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeMapper officeMapper;
    @Autowired
    PublicService publicService;
    @Autowired
    ActivityService activityService;

    //    获奖
    public String getAwardList() throws Exception {
        List<VoAward> voAwards = officeMapper.selectAllAward();
        for (VoAward voAward:
                voAwards){
            voAward.setVoCompetition(PageUtil.setCompetitionBycId(voAward.getCompetitionid()));
            voAward.setVoGrade(PageUtil.setGradeBygId(voAward.getGrade()));
            voAward.setVoLevel(PageUtil.setAwardLevelBylId(voAward.getLevel()));
            voAward.setVoState(PageUtil.setAwardStateByasId(voAward.getState()));
            System.out.println("voAward :\t"+voAward);
//            voAward.setAction(PageUtil.setAwardActionByeId(voAward.getAid().toString()));
        }
        return JSON.toJSONString(voAwards);
    }

    public String addAward(VoAward voAward, CommonsMultipartFile file, HttpServletRequest request) throws Exception {
        try {
            String path = PageUtil.uploadAnnex(request,file,voAward.getSchoolyear(),voAward.getAchievement(),"images");
            voAward.setAnnex(path);
            voAward.setEmployeenum(PageUtil.getUser().getEmployeenum());
            voAward.setState(0);
            System.out.println("service addAward\t"+voAward);
            voAward.setAid(officeMapper.insertAward(voAward));
            System.out.println("voAward have aid:\t"+voAward);
            activityService.startAwardProcess(voAward.getAid());
            return JSON.toJSONString("录入成功，请继续到“我的任务”办理当前申请");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("插入失败，请稍后再试");
        }
    }

//    教研论文管理
    public String getTeachingPaperList() throws Exception {
        List<VoTeachingPaper> teachingPaperList = officeMapper.selectAllTeachingPaper();
        for (VoTeachingPaper v:
             teachingPaperList) {
            v.setVoAnnex(PageUtil.setVoAnnexByUUID(v.getUuid()));
        }
        return JSON.toJSONString(teachingPaperList);
    }

    public String addTeachingPaper(VoTeachingPaper voTeachingPaper, HttpServletRequest request, CommonsMultipartFile file) throws Exception {
        voTeachingPaper.setAnnex(PageUtil.uploadAnnex(request,file,publicService.getSchoolYearBySyid(voTeachingPaper.getSchoolyear()),voTeachingPaper.getTitle(),"paper"));
        voTeachingPaper.setUuid(UUID.randomUUID().toString());
        voTeachingPaper.setLevel(1);
        voTeachingPaper.setType(1);
        try {
            officeMapper.insertTeachingPaper(voTeachingPaper);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            return "插入失败，请稍后再试";
        }
    }

    public String updateTeachingPaperByUUID(VoTeachingPaper voTeachingPaper,HttpServletRequest request, CommonsMultipartFile file) throws Exception {
        PageUtil.deleteFile(officeMapper.selectTeachingPaperByUUID(voTeachingPaper.getUuid()).getAnnex());
        voTeachingPaper.setAnnex(PageUtil.uploadAnnex(request,file,publicService.getSchoolYearBySyid(voTeachingPaper.getSchoolyear()),voTeachingPaper.getTitle(),"paper"));
        try {
            officeMapper.updateTeachingPaperByUUIDSelective(voTeachingPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    public String deleteTeachingPaperByUUID(String uuid) throws Exception {
        PageUtil.deleteFile(officeMapper.selectTeachingPaperByUUID(uuid).getAnnex());
        try {
            officeMapper.deleteTeachingPaperByUUID(uuid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    public VoTeachingPaper getTeachingPaperByUUID(String uuid) throws Exception {
        return officeMapper.selectTeachingPaperByUUID(uuid);
    }

    //    课题
    public String getTopicPaperList() throws Exception {
        return JSON.toJSONString(officeMapper.selectAllTopicPaper());
    }

    public String addTopicPaper(VoTopicPaper voTopicPaper) throws Exception {
        voTopicPaper.setUuid(UUID.randomUUID().toString());
        try {
            officeMapper.insertTopicPaper(voTopicPaper);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("插入失败，请稍后再试");
        }
    }

    public String updateTopicPaperByUUID(VoTopicPaper voTopicPaper) throws Exception {
        try{
            officeMapper.updateTopicPaperByUUIDSelective(voTopicPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    public String deleteTopicPaperByUUID(String uuid) throws Exception {
        try {
            officeMapper.deleteTopicPaperByUUID(uuid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    //    试卷
    public String getTestPaperList() throws Exception {
        return JSON.toJSONString(changeOne2Yes_TestPaper(officeMapper.selectAllTestPaper()));
    }

    public String addTestPaper(VoQuestionPaper voQuestionPaper) throws Exception {
        voQuestionPaper.setIschange("未修改");
        try{
            officeMapper.insertTestPaper(voQuestionPaper);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("插入时出错，请稍后再试");
        }
    }

    public String updateTestPaperById(VoQuestionPaper voQuestionPaper) throws Exception {
        voQuestionPaper.setIschange("已修改");
        try {
            officeMapper.updateTestPaperByIdSelective(voQuestionPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    public String deleteTestPaperById(int qid) throws Exception {
        try {
            officeMapper.deleteTestPaperById(qid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }
//    实训
    public String getTrainingPaperList() throws Exception {
        return JSON.toJSONString(changeOne2Yes_TraningPaper(officeMapper.selectAllTrainingPaper()));
    }

    
    public String addTrainingPaper(VoTrainingPaper voTrainingPaper) throws Exception {
        voTrainingPaper.setIschange("未修改");
        try {
            officeMapper.insertTrainingPaper(voTrainingPaper);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("插入失败，请稍后再试");
        }
    }

    
    public String updateTrainingPaperById(VoTrainingPaper voTrainingPaper) throws Exception {
        voTrainingPaper.setIschange("已修改");
        try {
            officeMapper.updateTrainingPaperByIdSelective(voTrainingPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    
    public String deleteTrainingPaperById(int tid) throws Exception {
        try {
            officeMapper.deleteTrainingPaperById(tid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    public List<VoQuestionPaper> changeOne2Yes_TestPaper (List<VoQuestionPaper> voQuestionPaperList){
        for (VoQuestionPaper v :
                voQuestionPaperList) {
            switch (v.getPsource()){
                case 1:v.setSpsource("自拟");break;
                case 2:v.setSpsource("统一命题");break;
            }
            switch (v.getExamineway()){
                case 1:v.setSexamineway("开卷");break;
                case 2:v.setSexamineway("闭卷");break;
                case 3:v.setSexamineway("答辩");break;
                case 4:v.setSexamineway("大作业");break;
                case 5:v.setSexamineway("上机");break;
            }
            switch (v.getAnalyzes()){
                case 0:v.setSanalyzes("否");break;
                case 1:v.setSanalyzes("是");break;
            }
            switch (v.getPlan()){
                case 0:v.setSplan("否");break;
                case 1:v.setSplan("是");break;
            }
            switch (v.getInvigilation()){
                case 0:v.setSinvigilation("否");break;
                case 1:v.setSinvigilation("是");break;
            }
            switch (v.getAb()){
                case 0:v.setSab("否");break;
                case 1:v.setSab("是");break;
            }
            switch (v.getAnswer()){
                case 0:v.setSanswer("否");break;
                case 1:v.setSanswer("是");break;
            }
            switch (v.getStandard()){
                case 0:v.setSstandard("否");break;
                case 1:v.setSstandard("是");break;
            }
            switch (v.getScore()){
                case 0:v.setSscore("否");break;
                case 1:v.setSscore("是");break;
            }
        }
        return voQuestionPaperList;
    }
    public List<VoTrainingPaper> changeOne2Yes_TraningPaper (List<VoTrainingPaper> voTrainingPaperList){
        for (VoTrainingPaper v :
                voTrainingPaperList) {
            switch (v.getPsource()){
                case 1:v.setSpsource("自拟");break;
                case 2:v.setSpsource("统一命题");break;
            }
            v.setSexamineway("答辩");
            switch (v.getAnalyzes()){
                case 0:v.setSanalyzes("否");break;
                case 1:v.setSanalyzes("是");break;
            }
            switch (v.getPlan()){
                case 0:v.setSplan("否");break;
                case 1:v.setSplan("是");break;
            }

            switch (v.getStandard()){
                case 0:v.setSstandard("否");break;
                case 1:v.setSstandard("是");break;
            }
            switch (v.getScore()){
                case 0:v.setSscore("否");break;
                case 1:v.setSscore("是");break;
            }
        }
        return voTrainingPaperList;
    }
}
