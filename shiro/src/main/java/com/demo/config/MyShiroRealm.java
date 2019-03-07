package com.demo.config;

import com.demo.dao.PermissionDao;
import com.demo.dao.RoleDao;
import com.demo.dao.RolePermissionDao;
import com.demo.dao.UserRoleDao;
import com.demo.model.*;
import com.demo.sevice.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * <p>
 * Create on 2019/03/01
 *
 * @author zouyongsheng
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserRoleDao userRoleDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private RolePermissionDao rolePermissionDao;

    @Resource
    private PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = null;
        userInfo = (UserInfo)principals.getPrimaryPrincipal();

        UserRoleQuery userRoleQuery = new UserRoleQuery();
        userRoleQuery.createCriteria().andUserIdEqualTo(userInfo.getId());
        List<UserRole> userRoleList = userRoleDao.selectByExample(userRoleQuery);
        if(userRoleList.size()>0){
            userRoleList.stream().forEach(userRole -> {
                RoleQuery roleQuery = new RoleQuery();
                roleQuery.createCriteria().andIdEqualTo(userRole.getRoleId());
                List<Role> roleList = roleDao.selectByExample(roleQuery);
                authorizationInfo.addRole(roleList.get(0).getRole());
                RolePermissionQuery rolePermissionQuery = new RolePermissionQuery();
                rolePermissionQuery.createCriteria().andRoleIdEqualTo(userRole.getRoleId());
                List<RolePermission> rolePermissionList = rolePermissionDao.selectByExample(rolePermissionQuery);
                List<Integer> permissionIdList = rolePermissionList.stream().map(RolePermission::getId).collect(Collectors.toList());

                PermissionQuery permissionQuery = new PermissionQuery();
                permissionQuery.createCriteria().andIdIn(permissionIdList);
                List<Permission> permissionList = permissionDao.selectByExample(permissionQuery);

                for(Permission p : permissionList){
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            });
        }

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(), //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getUsername()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
