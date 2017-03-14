package cn.wan.sdutoa.service;

import cn.wan.sdutoa.vo.VoNotice;
import cn.wan.sdutoa.vo.VoSystemDDL;

/**
 * Created by 万洪基 on 2017/3/9.
 */
public interface SystemService {

    public String dictionaryListAll() throws Exception;

    public String dictionaryListByKeyword(String keyword) throws Exception;

    public String addDictionary(VoSystemDDL voSystemDDL) throws Exception;

    public String updateDictionaryByUUID(String uuid,VoSystemDDL voSystemDDL) throws Exception;

    public String deleteDictionaryByUUID(String uuid) throws Exception;

    public String noticeListAll() throws Exception;

    public String addNotice(VoNotice voNotice) throws Exception;

    public String deleteNoticeByUUID(String uuid) throws Exception;

    public String noticeByUUID(String uuid) throws Exception;
}
