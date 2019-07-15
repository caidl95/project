package com.mmall.permission.controller;

import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.dto.DeptLevelDto;
import com.mmall.permission.param.DeptParam;
import com.mmall.permission.service.ISysDeptService;
import com.mmall.permission.service.ISysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/dept")
public class SysDeptController extends BaseController{

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysTreeService sysTreeService;

    @PostMapping("/save")
    public JsonData saveDept(DeptParam param){
        sysDeptService.save(param);
        return JsonData.success();
    }


    @GetMapping("/tree")
    public JsonData tree() {
        List<DeptLevelDto> dtoList = sysTreeService.deptTree();
        return JsonData.success(dtoList);
    }

    @PostMapping("/update")
    public JsonData updateDept(DeptParam param) {
        sysDeptService.update(param);
        return JsonData.success();
    }

    @PostMapping("/delete")
    public JsonData delete(@RequestParam("id") int id) {
        sysDeptService.delete(id);
        return JsonData.success();
    }

}
