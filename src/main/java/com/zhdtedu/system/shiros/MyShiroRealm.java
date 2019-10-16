package com.zhdtedu.system.shiros;

import com.zhdtedu.system.dao.entity.Privilege;
import com.zhdtedu.system.dao.entity.Role;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.service.PrivilegeService;
import com.zhdtedu.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
//实现AuthorizingRealm接口用户用户认证
public class MyShiroRealm extends AuthorizingRealm{

    private static UserService userService;
    @Autowired
    public void setSecurityService(UserService userService) {
        this.userService = userService;
    }

    private static PrivilegeService privilegeService;
    @Autowired
    public void setSecurityService(PrivilegeService privilegeServic) {
        this.privilegeService = privilegeServic;
    }
    /*@Autowired
    private PrivilegeService privilegeService;*/


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        //获取登录用户
        User  user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("name："+user);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roleByUid = userService.findRoleByUid(user.getUserId());
       List<Privilege> privilegeList = null;
        for (Role role:roleByUid) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            try {
                privilegeList = privilegeService.getPrivilegeListBy(role.getRoleId());
                //添加权限
                for (Privilege p:privilegeList) {
                    System.out.println("get(i):"+p);
                    simpleAuthorizationInfo.addStringPermission(p.getUrl());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("ssssss"+simpleAuthorizationInfo.getStringPermissions());
        return simpleAuthorizationInfo;

    }
    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户输入的账号
        String account = (String)authenticationToken.getPrincipal();
        System.out.println("名字2："+account);
        //2.通过username从数据库中查找到user实体
       // User user = getUserByUserName(username);
        User user = null;
      //  System.out.println("user"+userService.getByAccount(account));
        try{
            user= userService.getByAccount(account);
        }catch (Exception e){

        }
       // System.out.println("user++++"+user);
        User ara_user = null;
        try{
            ara_user= userService.getByAccount(account);
        }catch (Exception e){

        }
        if(user == null||"".equals(user)){
            System.out.println("user++++++++++"+user);
            return null;
        }
        //3.通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(user,ara_user.getPassword(),this.getName());
        //4.用户账号状态验证等其他业务操作
        /*if(user.getAccount()!=account){
            throw new AuthenticationException("该账号已经被禁用");
        }*/
        System.out.println("simpleAuthenticationInfo："+simpleAuthenticationInfo);
        //5.返回身份处理对象
        return simpleAuthenticationInfo;
        }

    }
