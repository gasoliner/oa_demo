package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.OfficeMapper;
import cn.wan.sdutoa.service.OfficeService;
import cn.wan.sdutoa.vo.VoQuestionPaper;
import cn.wan.sdutoa.vo.VoTrainingPaper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 万洪基 on 2017/2/27.
 */
@Service("officeService")
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    OfficeMapper officeMapper;

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

    @Override
    public String updateTestPaperById(VoQuestionPaper voQuestionPaper) throws Exception {
        voQuestionPaper.setIschange("已修改");
        try {
            officeMapper.updateTestPaperByIdSelective(voQuestionPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    @Override
    public String deleteTestPaperById(int qid) throws Exception {
        try {
            officeMapper.deleteTestPaperById(qid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }
//    实训
    @Override
    public String getTrainingPaperList() throws Exception {
        return JSON.toJSONString(changeOne2Yes_TraningPaper(officeMapper.selectAllTrainingPaper()));
    }

    @Override
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

    @Override
    public String updateTrainingPaperById(VoTrainingPaper voTrainingPaper) throws Exception {
        voTrainingPaper.setIschange("已修改");
        try {
            officeMapper.updateTrainingPaperByIdSelective(voTrainingPaper);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    @Override
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
