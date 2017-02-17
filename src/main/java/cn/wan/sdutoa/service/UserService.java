package cn.wan.sdutoa.service;

import cn.wan.sdutoa.vo.VoUser;

import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/16.
 */
public interface UserService {
    public List<VoUser> userList (int page, int pageSize) throws Exception;
    public int userAdd (VoUser voUser) throws Exception;
    public long countAllUser()throws Exception;
}
