package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.SystemService;
import cn.wan.sdutoa.vo.VoSystemDDL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 万洪基 on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/system",produces = {"application/json;charset=UTF-8"})
public class SystemController {
    @Autowired
    SystemService systemService;

    @RequestMapping("/dictionary/list/{keyword}")
    @ResponseBody
    public String dictionaryList(@PathVariable String keyword) throws Exception {
        return systemService.dictionaryListByKeyword(keyword);
    }

    @RequestMapping("/dictionary/addition")
    @ResponseBody
    public String dictionaryAddition(VoSystemDDL voSystemDDL) throws Exception {
        return systemService.addDictionary(voSystemDDL);
    }

    @RequestMapping("/dictionary/updates/{uuid}")
    @ResponseBody
    public String dictionaryUpdates(@PathVariable String uuid, VoSystemDDL voSystemDDL) throws Exception {
        return systemService.updateDictionaryByUUID(uuid,voSystemDDL);
    }

    @RequestMapping(value = "/dictionary/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String dictionaryDeletion(@PathVariable String uuid) throws Exception {
        return systemService.deleteDictionaryByUUID(uuid);
    }
}
