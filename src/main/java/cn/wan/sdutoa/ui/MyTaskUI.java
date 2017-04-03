package cn.wan.sdutoa.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wanzhenghang on 2017/4/3.
 */
@Controller
@RequestMapping("/myTask")
public class MyTaskUI {

    @RequestMapping("/todoTask")
    public String todoTask(){
        return "personalOffice/myTask/todoTask";
    }

    @RequestMapping("/assignedTask")
    public String assignedTask(){
        return "personalOffice/myTask/assignedTask";
    }
}
