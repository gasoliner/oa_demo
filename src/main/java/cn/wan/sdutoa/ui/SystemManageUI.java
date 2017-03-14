package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/3/9.
 */
@Controller
@RequestMapping("/system")
public class SystemManageUI {

    @RequestMapping("/dictionaryManage")
    public String dictionaryManage(){
        return "systemManage/dictionaryManage";
    }

    @RequestMapping("/roleManage")
    public String roleManage(){
        return "systemManage/roleManage";
    }

    @RequestMapping("/noticeManage")
    public String noticeManage(){
        return "systemManage/noticeManage";
    }

}
