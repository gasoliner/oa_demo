package cn.wan.sdutoa.controller;

import cn.wan.sdutoa.service.SystemService;
import cn.wan.sdutoa.vo.VoNotice;
import cn.wan.sdutoa.vo.VoSystemDDL;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequiresRoles("1")
    @RequestMapping("/dictionary/list/{keyword}")
    @ResponseBody
    public String dictionaryList(@PathVariable String keyword) throws Exception {
        return systemService.dictionaryListByKeyword(keyword);
    }

    @RequiresRoles("1")
    @RequestMapping("/dictionary/addition")
    @ResponseBody
    public String dictionaryAddition(VoSystemDDL voSystemDDL) throws Exception {
        return systemService.addDictionary(voSystemDDL);
    }

    @RequiresRoles("1")
    @RequestMapping("/dictionary/updates/{uuid}")
    @ResponseBody
    public String dictionaryUpdates(@PathVariable String uuid, VoSystemDDL voSystemDDL) throws Exception {
        return systemService.updateDictionaryByUUID(uuid,voSystemDDL);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/dictionary/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String dictionaryDeletion(@PathVariable String uuid) throws Exception {
        return systemService.deleteDictionaryByUUID(uuid);
    }

    @RequestMapping("/notice/list")
    @ResponseBody
    public String noticeList() throws Exception {
        return systemService.noticeListAll();
    }

    @RequiresRoles("1")
    @RequestMapping("/notice/addition")
    @ResponseBody
    public String noticeAddition(VoNotice voNotice) throws Exception {
        return systemService.addNotice(voNotice);
    }

    @RequiresRoles("1")
    @RequestMapping(value = "/notice/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String noticeDeletion(@PathVariable String uuid) throws Exception {
        return systemService.deleteNoticeByUUID(uuid);
    }

    @RequestMapping("/notice/{uuid}")
    @ResponseBody
    public String noticeByUUID(@PathVariable String uuid) throws Exception {
        return systemService.noticeByUUID(uuid);
    }
}
