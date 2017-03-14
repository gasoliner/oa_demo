package cn.wan.sdutoa.mapper;

import cn.wan.sdutoa.vo.VoNotice;
import cn.wan.sdutoa.vo.VoSystemDDL;

import java.util.List;

/**
 * Created by 万洪基 on 2017/3/10.
 */
public interface SystemMapper {

    void insertSystemDDL(VoSystemDDL voSystemDDL);

    void updateSystemDDLByUUIDSelective(VoSystemDDL voSystemDDL);

    void deleteSystemDDLByUUID(String uuid);

    List<VoNotice> getNoticeList();

    void insertNotice(VoNotice voNotice);

    void deleteNoticeByUUID(String uuid);

    String getNoticeByUUID(String uuid);
}
