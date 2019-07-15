package com.mmall.permission.controller;


import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.ServerResponse;
import com.mmall.permission.exception.ParamException;
import com.mmall.permission.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
public abstract class BaseController {

    @ExceptionHandler({ParamException.class,PermissionException.class})
    public JsonData handleException(Throwable e) {
        if (e instanceof ParamException) {
            log.error(e.getMessage());
            return JsonData.success(e.getMessage());
        } else if (e instanceof PermissionException){
            log.error(e.getMessage());
            return JsonData.success(e.getMessage());
        }
        log.error("出现未知异常！");
        return JsonData.success("网络走丢啦！");
    }
}
