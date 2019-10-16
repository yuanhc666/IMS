package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.system.dao.entity.*;
import com.zhdtedu.system.service.DepartmentService;
import com.zhdtedu.system.service.PrivilegeService;
import com.zhdtedu.system.service.UserService;

import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
//@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private PrivilegeService privilegeService;

    int  currentPageNo=0;
    int  pageSize=10;
    int totalCount=0;
    /**
     * 获取用户列表
     *
     *params:deptId部门节点的id
     *
     *
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    /*@ApiOperation(value = "获取用户列表", notes = "根据部门deptId，索引页pageIndex获取数据列表")
    @GetMapping("/usersLis")
    public RcsResult getUserList( @ApiParam( name="account", value="部门id") @RequestParam(value="account",required = false) String account) {


        System.out.println(account);
        try {
            User user = userService.getByAccount(account);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, e.getMessage());
        }

        return RcsResult.build(200, "没有用户，请重新输入！", null);
    }*/

    /**
     * 获取用户列表
     *
     *params:名称userName，职务role
     *
     *
     */
    //@ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取用户列表", notes = "根据名称userName，职务role，部门deptId，索引页pageIndex获取数据列表")
    @GetMapping("/users")
    public RcsResult getUserByList( @ApiParam( name="userName", value="名称") @RequestParam(value="userName",required = false) String userName,
                                    @ApiParam( name="role", value="职务") @RequestParam(value="role",required = false) String role,
                                    @ApiParam( name="deptId", value="部门id") @RequestParam(value="deptId",required = false) Integer deptId,
                                  @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
        List<User> userList =null;
        System.out.println("pageIndex"+pageIndex);
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        totalCount= userService.getTotalCountBy(userName,role,deptId);
        System.out.println("totalCount:"+totalCount);
        if(totalCount>0){
            PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);
            try {
                userList = userService.getUserListBy(userName,role,deptId,currentPageNo,pageSize);
                for(User u:userList){
                    System.out.println("用户："+u.toString());
                }
            }catch (Exception e){
                e.printStackTrace();
                return  RcsResult.build(500, e.getMessage());
            }
            pageModel.setList(userList);
            return  RcsResult.ok(pageModel);
        }else {
            return RcsResult.build(200, "没有用户，请重新输入！", null);
        }
    }
/**
     * 新增用户部门数据
     * params：获取选中的parentId
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "新增用户信息数据", notes = "新增用户信息数据")
    @ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
    @PostMapping("/users")
    public RcsResult saveUser( @RequestBody User user){
        System.out.println("用户++++++++"+user);
        User byAccount = userService.getByAccount(user.getAccount());
        if(byAccount==null){
            userService.saveUser(user);
            System.out.println("用户ID"+user.getUserId());
            UserDepartment userDepartment=new UserDepartment();
            System.out.println("部门ID"+user.getDepartments().get(0).getDeptId());
            userDepartment.setUserId(user.getUserId());
            userDepartment.setDeptId(user.getDepartments().get(0).getDeptId());
            userService.userDepartmentAdd(userDepartment);
            UserRole userRole=new UserRole();
            RcsResult result = null;
            System.out.println("角色ID"+user.getRoles().get(0).getRoleId());
            userRole.setRoleId(user.getRoles().get(0).getRoleId());
            userRole.setUserId(user.getUserId());
            result= userService.userRoleAdd(userRole);
            return RcsResult.build(200, "新增成功！", null);
        }
        return RcsResult.build(200, "账户存在！", null);
    }


/**
     * 删除用户数据
     * params:id
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "删除用户,部门用户数据", notes = "删除用户，部门用户数据")
    @DeleteMapping("/users/{id}")
    public RcsResult deleteUser(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") int id){
        userService.deleteUser(id);
        userService.userRoleDelete(id);
        RcsResult result=userService.userDepartmentDelete(id);
        return  result;
    }
    /*
     * 修改用户保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "修改用户后保存", notes = "根据节点id更新数据")
    @PutMapping("/users")
    public  RcsResult   modifyUser( @RequestBody User  user){
        System.out.println("用户xiug++++++++"+user);
        User byAccount = userService.getByAccount(user.getAccount());
        if(byAccount==null){
            userService.updateUser(user);
            System.out.println("用户ID"+user.getUserId());
            userService.userDepartmentDelete(user.getUserId());
            UserDepartment userDepartment=new UserDepartment();
            System.out.println("部门ID"+user.getDepartments().get(0).getDeptId());
            userDepartment.setUserId(user.getUserId());
            userDepartment.setDeptId(user.getDepartments().get(0).getDeptId());
            userService.userDepartmentAdd(userDepartment);
            UserRole userRole=new UserRole();
            RcsResult result = null;
            userService.userRoleDelete(user.getUserId());
            System.out.println("角色ID"+user.getRoles().get(0).getRoleId());
            userRole.setRoleId(user.getRoles().get(0).getRoleId());
            userRole.setUserId(user.getUserId());
            result= userService.userRoleAdd(userRole);
            System.out.println("用户xiug+++888+"+user);
            return RcsResult.build(200, "修改成功！", null);
        }
        return RcsResult.build(200, "账户存在！", null);

    }
    /**
     * 获取动态树节点
     */
   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/users/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= userService.getNodeList();
        return  result;
    }

   // @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
   /* @ApiOperation(value = "登录用户", notes = "登录")
    @PostMapping("/login")
    public RcsResult login(*//*@ApiParam( name="account", value="账号") @RequestParam(value="account",required = false) String account,
                           @ApiParam( name="password", value="密码") @RequestParam(value="password",required = false) String password*//*
            ) {
        User login = userService.login(user.getAccount(), user.getPassword());
        if(login==null){
            return RcsResult.build(200, "输入的密码或者账户有误，请重新输入！", null);
        }
        System.out.println(login.getUserId());
        List<Role> roleByUid = userService.findRoleByUid(login.getUserId());
        List<Privilege> privilegeList =null;
       for(int i = 0;i < roleByUid.size();i++){
           System.out.println(roleByUid.get(i));
           try {
               privilegeList=privilegeService.getPrivilegeListBy(roleByUid.get(i).getRoleId());
           }catch (Exception e){
               e.printStackTrace();
               return  RcsResult.build(500, e.getMessage());
           }
       }
        return  RcsResult.ok(privilegeList);

    }*/
   //@RequestMapping(value = "/login", method = RequestMethod.GET)

    @PostMapping("/login")
    public Map<String,Object>  login(@RequestParam("account") String account, @RequestParam("password") String password,
                                     HttpServletRequest httpServletRequest/*,@RequestBody User  user*/){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Session session = SecurityUtils.getSubject().getSession();
        //转化成小写字母
     /*  String account = user.getAccount();
       String password = user.getPassword();*/
        // 获取当前的 Subject. 调用 SecurityUtils.getSubject();
        Subject currentUser = SecurityUtils.getSubject();
        // 测试当前的用户是否已经被认证. 即是否已经登录.
        // 调动 Subject 的 isAuthenticated()
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            // rememberme
            token.setRememberMe(true);
            try {
               System.out.println("UsernamePasswordToken:" + token.toString());
               System.out.println("hashCode:" + token.hashCode());
               System.out.println("Principal:" + token.getPrincipal());
               System.out.println("Credentials:" + String.valueOf((char[]) token.getCredentials()));
               System.out.println("host:" + token.getHost());
               System.out.println("Username:" + token.getUsername());
               System.out.println("Password:" + String.valueOf(token.getPassword()));
                // 执行登录.
                currentUser.login(token);
                System.out.println("执行登录:" + String.valueOf(token.getPassword()));
                User user= userService.getByAccount(account);
                List<Role> roleByUid = userService.findRoleByUid(user.getUserId());
                for (int i = 0; i < roleByUid.size(); i++) {
                    System.out.println(roleByUid.get(i).getRoleName());
                    Permission p1=new WildcardPermission(roleByUid.get(i).getRoleName());
                    System.out.println("p1.toString()"+p1.toString());
                    if(currentUser.isPermitted(p1)) {
                        System.out.println(token.getPrincipal()+"token.getPrincipal()");
                    }else {
                        System.out.println(token.getPrincipal()+"没有bumen:diwubu:update的权限");
                    }
                }
            /*    List<Privilege> privilegeList =null;
                for(int i = 0;i < roleByUid.size();i++){
                    System.out.println(roleByUid.get(i));
                    try {
                        privilegeList=privilegeService.getPrivilegeListBy(roleByUid.get(i).getRoleId());

                    }catch (Exception e){
                        e.printStackTrace();
                        resultMap.put("status", 500);
                        resultMap.put("message", 500);
                    }
                }
                resultMap.put("privilegeList", privilegeList);*/
                String tokens= String.valueOf(token);
                resultMap.put("token", tokens);
                resultMap.put("status", 200);
                resultMap.put("message", "登录成功");
                // 所有认证时异常的父类.
            }catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("login failed :" + ae.getMessage());
            }
        } else{
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            token.clear();
            resultMap.put("status", 500);
            resultMap.put("message", 500);
        }
        return resultMap;
    }
    //登录用户详情
    @GetMapping(value = "/info")
    public Map<String,Object> info(String token) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            System.out.println("login failed :" + token);
            String []st=token.split(",");
            String name=null;
            System.out.println("login failed2 :" + st[0]);
            String []st1=st[0].split(" - ");
            System.out.println("login failed3 :" + st1[1]);

            //用户
            User user = userService.getByAccount(st1[1]);
            System.out.println("login user :" +user);
            resultMap.put("user", user);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultMap;
    }


    //登出
    @GetMapping(value = "/logout")
    public Map<String,Object> logout() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {
            //退出
            SecurityUtils.getSubject().logout();
            resultMap.put("status", 200);
            resultMap.put("message", "退出成功");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultMap;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }



}


