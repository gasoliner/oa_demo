package cn.wan.sdutoa.mapper;


import cn.wan.sdutoa.po.Dependent;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.Role;

import java.util.List;

public interface PublicMapper {

    List<Role> getRoleDDL();

    List<Dependent> getDependentDDL();

    List<FrontQuery> getSchoolYearDDL();
}