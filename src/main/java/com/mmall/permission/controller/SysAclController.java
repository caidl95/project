package com.mmall.permission.controller;

import com.google.common.collect.Maps;
import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.model.SysRole;
import com.mmall.permission.param.AclParam;
import com.mmall.permission.service.ISysAclService;
import com.mmall.permission.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/acl")
@Slf4j
public class SysAclController extends BaseController {

    @Autowired
    private ISysAclService sysAclService;
    @Autowired
    private ISysRoleService sysRoleService;

    @PostMapping("/save")
    public JsonData saveAclModule(AclParam param) {
        sysAclService.save(param);
        return JsonData.success();
    }

    @PostMapping("/update")
    public JsonData updateAclModule(AclParam param) {
        sysAclService.update(param);
        return JsonData.success();
    }

    @GetMapping("/page")
    public JsonData list(@RequestParam("aclModuleId") Integer aclModuleId, PageQuery pageQuery) {
        return JsonData.success(sysAclService.getPageByAclModuleId(aclModuleId, pageQuery));
    }

    @GetMapping("/acls")
    public JsonData acls(@RequestParam("aclId") int aclId) {
        Map<String, Object> map = Maps.newHashMap();
        List<SysRole> roleList = sysRoleService.getRoleListByAclId(aclId);
        map.put("roles", roleList);
        map.put("users", sysRoleService.getUserListByRoleList(roleList));
        return JsonData.success(map);
    }
}
