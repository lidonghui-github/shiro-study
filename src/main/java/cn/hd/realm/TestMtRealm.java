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
        //创建securityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //设置为自定义realm获取认证数据
        securityManager.setRealm(new MyRealm());
        //将安全工具类中设置默认安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("lidonghui", "123456");
        //用户登录
        subject.login(token);
        System.out.println(subject.getPrincipal());
        System.out.println(subject.isAuthenticated());

    }
}
