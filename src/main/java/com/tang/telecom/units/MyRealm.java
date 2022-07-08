package com.tang.telecom.units;

import com.tang.telecom.entity.User;
import com.tang.telecom.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author weepppp 2022/7/8 15:56
 **/
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userMapper.getByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户名输入错误");
        }
         ByteSource salt = ByteSource.Util.bytes(user.getUsername());
         return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), salt,getName());
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissions =  userMapper.getUserPermissionByUsername(username);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("MD5");
        matcher.setHashIterations(1024);
        return matcher;
    }
}

