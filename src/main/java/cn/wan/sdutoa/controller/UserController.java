package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.po.DataGrid;
import cn.wan.sdutoa.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/list")
    @ResponseBody
    public String userList(int page,int rows) throws Exception {
        DataGrid dataGrid = new DataGrid();
        dataGrid.setTotal(userService.countAllUser());
        dataGrid.setRows(userService.userList(page,rows));
        return JSON.toJSONString(dataGrid);
    }
}
