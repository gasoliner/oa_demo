package cn.wan.sdutoa.ui;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/3/9.
 */
@Controller
@RequestMapping("/system")
public class SystemManageUI {

    @RequiresRoles("1")
    @RequestMapping("/dictionaryManage")
    public String dictionaryManage(){
        return "systemManage/dictionaryManage";
    }

    @RequiresRoles("1")
    @RequestMapping("/roleManage")
    public String roleManage(){
        return "systemManage/roleManage";
    }

    @RequiresRoles("1")
    @RequestMapping("/noticeManage")
    public String noticeManage(){

        return "systemManage/noticeManage";
    }

    @RequiresRoles("1")
    @RequestMapping("processManage")
    public String processManage(){
        return "systemManage/processManage";
    }

}
