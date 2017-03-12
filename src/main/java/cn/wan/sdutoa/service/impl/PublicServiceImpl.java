package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.PublicMapper;
import cn.wan.sdutoa.po.Dependent;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.Role;
import cn.wan.sdutoa.service.PublicService;
import cn.wan.sdutoa.vo.VoSystemDDL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
@Service("publicService")
public class PublicServiceImpl implements PublicService {
    @Autowired
    PublicMapper publicMapper;

    public List<Role> getRoleDDL() throws Exception {
        return publicMapper.getRoleDDL();
    }

    public List<Dependent> getDependentDDL() throws Exception {
        return publicMapper.getDependentDDL();
    }

    public List<FrontQuery> getSchoolYearDDL() throws Exception {
        return publicMapper.getSchoolYearDDL();
    }

    public String getSchoolYearBySyid(String syid) throws Exception {
        return publicMapper.getSchoolYearBySyid(Integer.parseInt(syid));
    }

    public List<FrontQuery> getBookLevel() throws Exception {
        return publicMapper.getBookLevelDDL();
    }

    public List<FrontQuery> getSearchType() throws Exception {
        return publicMapper.getSearchTypeDDL();
    }

    public List<VoSystemDDL> getDDLKeywordALL() throws Exception {
        return publicMapper.getDDLKeywordALL();
    }
}
