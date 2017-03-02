package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/2/26.
 */
@Controller
@RequestMapping("/personalManageUI")
public class PersonalManageUI {

    @RequestMapping("/personalInfo")
    public String personalInfo(){
        return "personalManage/personalInfo";
    }

    @RequestMapping("/personalPass")
    public String pesonalPass(){
        return "personalManage/personalPass";
    }
}
