package com.mmall.permission.controller;

import com.google.common.collect.Maps;
import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.beans.PageResult;
import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.param.UserParam;
import com.mmall.permission.service.ISysRoleService;
import com.mmall.permission.service.ISysTreeService;
import com.mmall.permission.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController{

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysTreeService sysTreeService;
    @Autowired
    private ISysRoleService sysRoleService;


    @PostMapping("/save")
    public JsonData saveUser(UserParam param) {
        sysUserService.save(param);
        return JsonData.success();
    }

    @PostMapping("/update")
    public JsonData updateUser(UserParam param) {
        sysUserService.update(param);
        return JsonData.success();
    }

    @GetMapping("/page")
    public JsonData page(@RequestParam("deptId") int deptId, PageQuery pageQuery) {
        PageResult<SysUser> result = sysUserService.getPageByDeptId(deptId, pageQuery);
        return JsonData.success(result);
    }

    @GetMapping("/acls")
    public JsonData acls(@RequestParam("userId") int userId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("acls", sysTreeService.userAclTree(userId));
        map.put("roles", sysRoleService.getRoleListByUserId(userId));
        return JsonData.success(map);
    }
}
