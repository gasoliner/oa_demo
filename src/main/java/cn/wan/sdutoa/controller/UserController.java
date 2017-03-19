package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.po.DataGrid;
import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.vo.VoUser;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wanzhenghang on 2017/2/16.
 */

@Controller
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
public class UserController {
    @Autowired
    UserService userService;

    @RequiresRoles("1")
    @RequestMapping(value = "/list")
    @ResponseBody
    public String userList(int page,int rows) throws Exception {
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(userService.countAllUser());
        dataGrid.setRows(userService.userList(page,rows));
        return JSON.toJSONString(dataGrid);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/addition")
    @ResponseBody
    public String userAdd(VoUser voUser)throws Exception{
        System.out.println(voUser);
        return userService.userAdd(voUser);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/updates/{uid}")
    @ResponseBody
    public String userUpdate(VoUser voUser,@PathVariable Long uid)throws Exception{
        voUser.setUid(uid);
        return userService.userUpdate(voUser);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/deletion/{uid}")
    @ResponseBody
    public String userDelete(@PathVariable Long uid)throws Exception{
        return userService.userDelete(uid);
    }

    @RequestMapping(value = "/personalInfo")
    @ResponseBody
    public String personalInfoUpdate(VoUser voUser) throws Exception {
        return userService.userUpdate(voUser);
    }

    @RequestMapping(value = "/signin")
    public String signIn(VoUser voUser){
        Subject currentUser = SecurityUtils.getSubject();
        try {
            String employeenum = voUser.getEmployeenum();
            String password = voUser.getPassword();
            UsernamePasswordToken token = new UsernamePasswordToken(employeenum,password);
            currentUser.login(token);//当前用户拿着这个token登录
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:index.jsp";
    }
}
