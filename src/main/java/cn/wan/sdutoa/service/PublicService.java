package cn.wan.sdutoa.service;

import cn.wan.sdutoa.po.Dependent;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.Role;
import cn.wan.sdutoa.vo.VoSystemDDL;

import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/17.
 */
public interface PublicService {

    public List<Role> getRoleDDL() throws Exception;

    public List<Dependent> getDependentDDL() throws Exception;

    public List<FrontQuery> getSchoolYearDDL() throws Exception;

    public String getSchoolYearBySyid(String syid) throws Exception;

    public List<FrontQuery> getBookLevel() throws Exception;

    public List<FrontQuery> getSearchType() throws Exception;

    public List<VoSystemDDL> getDDLKeywordALL() throws Exception;

    public List<FrontQuery> getCompetition() throws Exception;

    public List<FrontQuery> getAwardLevel() throws Exception;

    public List<FrontQuery> getGrade() throws Exception;

    public List<Role> getRoleHaveActiviti() throws Exception;

}
