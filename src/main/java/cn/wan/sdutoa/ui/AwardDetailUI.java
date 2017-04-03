package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/3/28.
 */
@Controller
@RequestMapping("/awardDetail")
public class AwardDetailUI {

    @RequestMapping("/manage")
    public String manage(){
        return "personalOffice/awardDetail/manage";
    }

    @RequestMapping("/listAll")
    public String listAll(){
        return "personalOffice/awardDetail/listAll";
    }
}
