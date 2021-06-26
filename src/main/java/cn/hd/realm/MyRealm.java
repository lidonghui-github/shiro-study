package cn.hd.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author lidonghui
 * @date 2021-06-26 23:53:49
 * @desc ...
 */
public class MyRealm  extends AuthorizingRealm {
    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到传入的用户名
        String principal = (String) token.getPrincipal();
        //将传入的用户名与数据库中的比较
        if("lidonghui".equals(principal)){
            //参数1：用户名
            //参数2：密码
            //参数3：realm 的名称
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal, "123456", this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
