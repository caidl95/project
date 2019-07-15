package com.mmall.permission.controller;


import com.mmall.permission.common.ApplicationContextHelper;
import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.dao.SysAclModuleMapper;
import com.mmall.permission.exception.ParamException;
import com.mmall.permission.exception.PermissionException;
import com.mmall.permission.model.SysAclModule;
import com.mmall.permission.param.TestVo;
import com.mmall.permission.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController extends BaseController{

    @RequestMapping("/hello")
    public JsonData hello() {
        log.info("hello");
        throw new PermissionException("test exception");
    }

    @RequestMapping("/validate")
    public JsonData validate(TestVo vo) {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
