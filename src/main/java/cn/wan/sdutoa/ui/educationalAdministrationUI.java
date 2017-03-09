package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/2/27.
 */
@Controller
@RequestMapping("/educationalAdministration")
public class educationalAdministrationUI {

    @RequestMapping("/testPaperManage")
    public String testPaperManage(){
        return "personalOffice/educationalAdministration/testPaperManage";
    }

    @RequestMapping("/trainingPaperManage")
    public String trainingPaperManage(){
        return "personalOffice/educationalAdministration/trainingPaperManage";
    }

    @RequestMapping("/topicPaperManage")
    public String topicPaperManage(){
        return "personalOffice/educationalAdministration/topicPaperManage";
    }

    @RequestMapping("/teachingPaperManage")
    public String teachingPaperManage(){
        return "personalOffice/educationalAdministration/teachingPaperManage";
    }


}
