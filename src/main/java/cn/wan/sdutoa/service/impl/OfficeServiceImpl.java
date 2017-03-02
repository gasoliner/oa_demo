package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.OfficeMapper;
import cn.wan.sdutoa.service.OfficeService;
import cn.wan.sdutoa.vo.VoQuestionPaper;
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

    public String getTestPaperList() throws Exception {
        return JSON.toJSONString(changeOne2Yes_TestPaper(officeMapper.selectAllTestPaper()));
    }

    public List<VoQuestionPaper> changeOne2Yes_TestPaper (List<VoQuestionPaper> voQuestionPaperList){
        for (VoQuestionPaper v :
                voQuestionPaperList) {
            switch (v.getPsource()){
                case 0:v.setSpsource("否");break;
                case 1:v.setSpsource("是");break;
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
}
