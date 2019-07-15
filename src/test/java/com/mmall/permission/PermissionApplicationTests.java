package com.mmall.permission;

import com.mmall.permission.dao.SysUserMapper;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionApplicationTests {

    @Autowired
    SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        SysUser data = sysUserMapper.findByKeyword("admin@qq.com");
        System.out.println(data);
    }

}
