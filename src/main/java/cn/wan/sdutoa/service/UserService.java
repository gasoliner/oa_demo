package cn.wan.sdutoa.service;

import cn.wan.sdutoa.po.JsjUser;
import cn.wan.sdutoa.vo.VoUser;

import java.util.List;
import java.util.Set;

/**
 * Created by wanzhenghang on 2017/2/16.
 */
public interface UserService {
    public List<VoUser> userList (int page, int pageSize) throws Exception;

    public String userAdd (VoUser voUser) throws Exception;

    public long countAllUser ()throws Exception;

    public String userUpdate (VoUser voUser) throws Exception;

    public String userDelete (Long uid) throws Exception;

    public VoUser getUserByEmployee(String em);

    public Set<String> getRolesByEmployee(String em);

    public Set<String> getPermissionsByEmployee(String em);
}
