package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 万洪基 on 2017/2/27.
 */
@Controller
@RequestMapping(value = "/office",produces = {"application/json;charset=UTF-8"})
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @RequestMapping("/testPaperList")
    @ResponseBody
    public String testPaperList() throws Exception {
        return officeService.getTestPaperList();
    }
}
