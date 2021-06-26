package cn.hd.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author lidonghui
 * @date 2021-06-26 23:58:14
 * @desc ...
 */
public class TestMtRealm {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new MyRealm());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lidonghui", "123456");
        subject.login(token);
        System.out.println(subject.getPrincipal());
        System.out.println(subject.isAuthenticated());

    }
}
