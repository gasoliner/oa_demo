package cn.wan.sdutoa.mapper;

import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.JsjUser;
import cn.wan.sdutoa.po.JsjUserExample;
import cn.wan.sdutoa.vo.VoUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface JsjUserMapper {
    long countByExample(JsjUserExample example);

    int deleteByExample(JsjUserExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(JsjUser record);

    int insertSelective(JsjUser record);

    List<JsjUser> selectByExample(JsjUserExample example);

    JsjUser selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") JsjUser record, @Param("example") JsjUserExample example);

    int updateByExample(@Param("record") JsjUser record, @Param("example") JsjUserExample example);

    int updateByPrimaryKeySelective(JsjUser record);

    int updateByPrimaryKey(JsjUser record);

//    自定义
    List<VoUser> selectAllUser (FrontQuery frontQuery);

    long countAllUser();

    VoUser getUserByEmployee(String employee);

    String getRolesByEmployee(String employee);

    String getPermissionByEmployee(String employee);

    List<String> getUserNameHaveActivitiByRole(String roleId);
}