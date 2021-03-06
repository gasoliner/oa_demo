package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.PublicService;
import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.util.ContantKey;
import cn.wan.sdutoa.vo.VoUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 万洪基 on 2017/3/14.
 */
@Controller
public class Login {
    @Autowired
    UserService userService;
    @Autowired
    PublicService publicService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(VoUser voUser, HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(voUser.getEmployeenum(),voUser.getPassword());
        try {
            currentUser.login(token);
            System.out.println("登录成功");
            voUser = userService.getUserByEmployee(voUser.getEmployeenum());
            session.setAttribute(ContantKey.GLOBLE_USER_INFO,voUser);
            session =loadAllCurrencyResource(session);
            return "/index";
        }catch (UnknownAccountException uae){
            System.out.println("用户名错误");
        }catch (LockedAccountException lae){
            System.out.println("账户锁定了");
        }
        return "/login_UI";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpSession session){
        session.removeAttribute(ContantKey.GLOBLE_USER_INFO);
        session.invalidate();
        return;
    }

    public HttpSession loadAllCurrencyResource(HttpSession session) {
        try {
            session.setAttribute("roles",publicService.getRoleDDL());
            session.setAttribute("depts",publicService.getDependentDDL());
            session.setAttribute("schoolyears",publicService.getSchoolYearDDL());
            session.setAttribute("booklevels",publicService.getBookLevel());
            session.setAttribute("searchtypes",publicService.getSearchType());
            session.setAttribute("keywords",publicService.getDDLKeywordALL());
            session.setAttribute("competitions",publicService.getCompetition());
            session.setAttribute("awardLevels",publicService.getAwardLevel());
            session.setAttribute("grades",publicService.getGrade());
            return session;
        }catch (Exception e){
            e.printStackTrace();
            return session;
        }
    }
}
