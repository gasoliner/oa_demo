package cn.wan.sdutoa.service;

import cn.wan.sdutoa.po.Dependent;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.Role;
import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
public interface PublicService {

    public List<Role> getRoleDDL() throws Exception;

    public List<Dependent> getDependentDDL() throws Exception;

    public List<FrontQuery> getSchoolYearDDL() throws Exception;

}
