package com.mmall.permission.controller;
import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.param.SearchLogParam;
import com.mmall.permission.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sys/log")
public class SysLogController extends BaseController{

    @Autowired
    private ISysLogService sysLogService;


    @PostMapping("/recover")
    public JsonData recover(@RequestParam("id") int id) {
        sysLogService.recover(id);
        return JsonData.success();
    }

    @PostMapping("/page")
    public JsonData searchPage(SearchLogParam param, PageQuery page) {
        return JsonData.success(sysLogService.searchPageList(param, page));
    }
}
