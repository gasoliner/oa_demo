package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.PublicService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
@Controller
@RequestMapping(value = "/public",produces = {"application/json;charset=UTF-8"} )
public class PublicController {
    @Autowired
    PublicService publicService;

    @RequestMapping("/rddl")
    @ResponseBody
    public String getRoleDDL() throws Exception {

        System.out.println(publicService.getRoleDDL());

        return JSON.toJSONString(publicService.getRoleDDL());
    }
}
