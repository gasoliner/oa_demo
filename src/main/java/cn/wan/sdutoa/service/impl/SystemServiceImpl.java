package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.PublicMapper;
import cn.wan.sdutoa.mapper.SystemMapper;
import cn.wan.sdutoa.service.SystemService;
import cn.wan.sdutoa.util.PageUtil;
import cn.wan.sdutoa.vo.VoNotice;
import cn.wan.sdutoa.vo.VoSystemDDL;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 万洪基 on 2017/3/9.
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {
    @Autowired
    PublicMapper publicMapper;
    @Autowired
    SystemMapper systemMapper;
    public String dictionaryListAll() throws Exception {
        return JSON.toJSONString(publicMapper.getSystemDDLAll());
    }

    public String dictionaryListByKeyword(String keyword) throws Exception {
        List<VoSystemDDL> list = publicMapper.getSystemDDLByKeyword(keyword);
        Collections.sort(list);
        return JSON.toJSONString(list);
    }

    public String addDictionary(VoSystemDDL voSystemDDL) throws Exception {
        voSystemDDL.setUuid(UUID.randomUUID().toString());
        List<VoSystemDDL> list = publicMapper.getSystemDDLByKeyword(voSystemDDL.getKeyword());
        Collections.sort(list);
        voSystemDDL.setDdlcode(list.get(list.size()-1).getDdlcode()+1);
        try {
            systemMapper.insertSystemDDL(voSystemDDL);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("插入失败，请稍后再试");
        }
    }

    public String updateDictionaryByUUID(String uuid, VoSystemDDL voSystemDDL) throws Exception {
        voSystemDDL.setUuid(uuid);
        voSystemDDL.setDdlcode(null);
        try {
            systemMapper.updateSystemDDLByUUIDSelective(voSystemDDL);
            return JSON.toJSONString("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("更新失败，请稍后再试");
        }
    }

    public String deleteDictionaryByUUID(String uuid) throws Exception {
        try {
            systemMapper.deleteSystemDDLByUUID(uuid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    public String noticeListAll() throws Exception {
        List<VoNotice> list = systemMapper.getNoticeList();
        for (VoNotice v:
             list) {
            v.setAction(PageUtil.setVoNoticeActionByUUID(v.getUuid()));
        }
        return JSON.toJSONString(list);
    }

//    voNotice.setUser没写
    public String addNotice(VoNotice voNotice) throws Exception {
        voNotice.setUuid(UUID.randomUUID().toString());
        voNotice.setBegindate(new Date(System.currentTimeMillis()));
        voNotice.setUser("testUser");
        System.out.println("service :\tadd\t"+voNotice);
        try {
            systemMapper.insertNotice(voNotice);
            return JSON.toJSONString("插入成功");
        }catch (Exception e){
            return JSON.toJSONString("插入失败，请稍后再试");
        }
    }

    public String deleteNoticeByUUID(String uuid) throws Exception {
        try {
            systemMapper.deleteNoticeByUUID(uuid);
            return JSON.toJSONString("删除成功");
        }catch (Exception e){
            return JSON.toJSONString("删除失败，请稍后再试");
        }
    }

    public String noticeByUUID(String uuid) throws Exception {
        System.out.println("service:\t"+systemMapper.getNoticeByUUID(uuid));
        return JSON.toJSONString(systemMapper.getNoticeByUUID(uuid));
    }

}
