package cn.wan.sdutoa.ui;

import cn.wan.sdutoa.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/userManageUI",produces = {"application/json;charset=UTF-8"} )
public class UserManageUI {


    @RequestMapping("/userList")
    public String userList(){
        return "userManage/userList";
    }

    @RequestMapping("/userAdd")
    public String userAdd() throws Exception {
        return "userManage/userAdd";
    }



}
