package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.PublicService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return JSON.toJSONString(publicService.getRoleDDL());
    }

    @RequestMapping("/dddl")
    @ResponseBody
    public String getDepDDL() throws Exception {
        return JSON.toJSONString(publicService.getDependentDDL());
    }

    @RequestMapping("/syddl")
    @ResponseBody
    public String getSchoolYear() throws Exception {
        return JSON.toJSONString(publicService.getSchoolYearDDL());
    }

    @RequestMapping("/blddl")
    @ResponseBody
    public String getBoolLevel() throws Exception{
        return JSON.toJSONString(publicService.getBookLevel());
    }

    @RequestMapping("/stddl")
    @ResponseBody
    public String getSearchType() throws Exception{
        return JSON.toJSONString(publicService.getSearchType());
    }
}
