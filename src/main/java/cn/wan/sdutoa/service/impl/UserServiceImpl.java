package cn.wan.sdutoa.service.impl;

import cn.wan.sdutoa.mapper.JsjUserMapper;
import cn.wan.sdutoa.po.FrontQuery;
import cn.wan.sdutoa.po.JsjUser;
import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.vo.VoUser;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public String userAdd(VoUser voUser) {
        voUser.setLocked(false);
        voUser.setPassword("000000");
        if (voUser.getRoleidsstr().equals("1")){
            voUser.setRole("管理员");
        }else {
            voUser.setRole("教师");
        }
        voUser.setSalt("default salt");
        try {
            jsjUserMapper.insert(voUser);
            return JSON.toJSONString("添加用户成功，请刷新查看");
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("添加用户失败，请检查后重新添加");
        }
    }
    public long countAllUser() throws Exception {
        return jsjUserMapper.countAllUser();
    }

    public String userUpdate(VoUser voUser) throws Exception {
        try {
            jsjUserMapper.updateByPrimaryKeySelective(voUser);
            return JSON.toJSONString("更新成功！");
        }catch (Exception e){
            return JSON.toJSONString("更新时出现错误，请稍后再试");
        }
    }

    public VoUser getUserByEmployee(String em) {
        return jsjUserMapper.getUserByEmployee(em);
    }

    public Set<String> getRolesByEmployee(String em) {
        Set<String> stringSet = new HashSet<String>();
        stringSet.add(jsjUserMapper.getRolesByEmployee(em));
        return stringSet;
    }

    public Set<String> getPermissionsByEmployee(String em) {
        String permissionAll = jsjUserMapper.getPermissionByEmployee(em);
        if (permissionAll != null && !permissionAll.trim().equals("")){
            String [] permissions = permissionAll.split(",");
            Set<String> stringSet = new HashSet<String>();
            for (String s:
                    permissions) {
                stringSet.add(s);
            }
            return stringSet;
        }
        return null;
    }
}
