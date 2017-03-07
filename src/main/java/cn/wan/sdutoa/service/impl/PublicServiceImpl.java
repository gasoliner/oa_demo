package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.PublicMapper;
import cn.wan.sdutoa.po.Dependent;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.Role;
import cn.wan.sdutoa.service.PublicService;
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

    @Override
    public List<FrontQuery> getSchoolYearDDL() throws Exception {
        return publicMapper.getSchoolYearDDL();
    }
}
