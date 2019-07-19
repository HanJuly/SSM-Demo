package com.han.mybatisdemo.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class GloalHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        GlobalException gloalHandlerException = new GlobalException(new Date(),e.getMessage());
        ModelAndView mv = new ModelAndView("error");
        mv.addObject(gloalHandlerException);
        return mv;
    }

    class GlobalException extends Exception{
        private Date date;
        private String message;

        public GlobalException(Date date, String message) {
            this.date = date;
            this.message = message;
        }

    }

}
