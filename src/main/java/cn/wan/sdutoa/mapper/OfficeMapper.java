package cn.wan.sdutoa.mapper;

import cn.wan.sdutoa.vo.VoQuestionPaper;

import java.util.List;

/**
 * Created by 万洪基 on 2017/2/27.
 */
public interface OfficeMapper {

//    试卷归档管理
    public List<VoQuestionPaper> selectAllTestPaper ();
}
