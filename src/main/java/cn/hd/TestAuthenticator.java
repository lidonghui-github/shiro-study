package cn.hd;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author lidonghui
 * @date 2021-06-26 21:33:51
 * @desc ...
 */
public class TestAuthenticator {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lidonghui", "123456");
        subject.login(token);
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.getPrincipal());

    }
}
