package com.wuliangit.shopos.core.realm;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.Member;
import com.wuliangit.shopos.service.AdminService;
import com.wuliangit.shopos.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class UserRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private MemberService memberService;

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //支持 UsernamePasswordToken 类型的 Token
        return token instanceof UserToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        HashMap<String, Object> user = (HashMap)principals;
        String username = (String)user.get("username");
        UserToken.LoginType loginType = (UserToken.LoginType)user.get("loginType");
        SimpleAuthorizationInfo authorizationInfo = null;
        if (loginType == UserToken.LoginType.MEMBER) {
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setRoles(memberService.getRoles(username));
            authorizationInfo.setStringPermissions(memberService.getPermissions(username));
        } else if(loginType == UserToken.LoginType.ADMIN){
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setRoles(adminService.getRoles(username));
            authorizationInfo.setStringPermissions(adminService.getPermissions(username));
        }
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = null;
        HashMap<String, Object> hashUser = (HashMap)token.getPrincipal();
        String username = (String)hashUser.get("username");
        UserToken userToken = (UserToken) token;
        if (userToken.getLoginType() == UserToken.LoginType.MEMBER) {
            Member user = memberService.getUserByOpenid(username);
            if(user == null){
                throw new UnknownAccountException();
            }
            authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), //用户名
                    user.getPasswd(), //密码
                    ByteSource.Util.bytes(user.getSalt()),
                    getName()
            );
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, user);
        } else if (userToken.getLoginType() == UserToken.LoginType.ADMIN) {
            Admin user = adminService.getByUsername(username);
            authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), //用户名
                    user.getPassword(), //密码
                    ByteSource.Util.bytes(user.getSalt()),
                    getName()
            );
            SecurityUtils.getSubject().getSession().setAttribute(CoreConstants.SESSION_CURRENT_USER, user);
        }

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
