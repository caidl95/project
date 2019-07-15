package com.mmall.permission.controller;

import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.param.AclModuleParam;

import com.mmall.permission.service.ISysAclModuleService;
import com.mmall.permission.service.ISysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/aclModule")
@Slf4j
public class SysAclModuleController extends BaseController{

    @Autowired
    private ISysAclModuleService sysAclModuleService;
    @Autowired
    private ISysTreeService sysTreeService;

    @PostMapping("/save")
    public JsonData saveAclModule(AclModuleParam param) {
        sysAclModuleService.save(param);
        return JsonData.success();
    }

    @PostMapping("/update")
    public JsonData updateAclModule(AclModuleParam param) {
        sysAclModuleService.update(param);
        return JsonData.success();
    }

    @GetMapping("/tree")
    public JsonData tree() {
        return JsonData.success(sysTreeService.aclModuleTree());
    }

    @PostMapping("/delete")
    public JsonData delete(@RequestParam("id") int id) {
        sysAclModuleService.delete(id);
        return JsonData.success();
    }
}
