package com.shop.fuelcoupons.web.interceptor;

import com.shop.fuelcoupons.AuthorizedUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            if (AuthorizedUser.id() != 0) {
                modelAndView.getModelMap().addAttribute("user", AuthorizedUser.getUser());
            }
        }
    }
}
