package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/3/14.
 */
@Controller
public class Login_UI {

    @RequestMapping("/login_UI")
    public String login_UI(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
