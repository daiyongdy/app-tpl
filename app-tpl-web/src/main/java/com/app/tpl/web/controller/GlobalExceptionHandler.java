package com.app.tpl.web.controller;


import com.app.tpl.common.exception.BizException;
import com.app.tpl.web.model.WebMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * <b>类名称：</b>GlobalExceptionHandler <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>zuti(zuti@centaur.com)<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2017/10/7 12:12<br/>
 * <b>修改备注：</b><br/>
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 运行时异常
     *
     * @param e
     * @param response
     * @return WebMessage
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public WebMessage exceptionHandler(Exception e, HttpServletResponse response) {
        //业务异常
        if (e instanceof BizException) {
            BizException bex = (BizException) e;

            return WebMessage.build(Integer.valueOf(bex.getCode()), bex.getMsg());
        }
        //其他服务器异常
        else {

            //打印到console
            e.printStackTrace();

            return WebMessage.build(500, "系统正忙,请稍后再试");
        }
    }

}
