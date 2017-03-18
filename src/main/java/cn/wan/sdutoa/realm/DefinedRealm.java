package cn.wan.sdutoa.realm;

import cn.wan.sdutoa.service.UserService;
import cn.wan.sdutoa.vo.VoUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 万洪基 on 2017/3/14.
 */
public class DefinedRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授予权限。。。。。。");
        String employee = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRolesByEmployee(employee));
        authorizationInfo.setStringPermissions(userService.getPermissionsByEmployee(employee));
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始验证登录信息。。。。。。");
        String userName = (String) authenticationToken.getPrincipal();
        VoUser voUser = userService.getUserByEmployee(userName);
        if(voUser == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if(Boolean.TRUE.equals(voUser.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                voUser.getEmployeenum(),
                voUser.getPassword(),
//                ByteSource.Util.bytes(voUser.getSalt()),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
