package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.JsjUserMapper;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.vo.VoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanzhenghang on 2017/2/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    JsjUserMapper jsjUserMapper;
    public List<VoUser> userList(int page, int pageSize) throws Exception {
        return jsjUserMapper.selectAllUser(new FrontQuery((page-1)*pageSize,pageSize));
    }

    public int userAdd(VoUser voUser) {
        return 0;
    }

    public long countAllUser() throws Exception {
        return jsjUserMapper.countAllUser();
    }
}
