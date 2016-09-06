package com.yihou.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by YuPan on 2016/9/6.
 */
public class SecurityInterceptor implements HandlerInterceptor {

    private List<String> excludeUrls;// 不需要拦截的资源

    public List<String> getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestUri = httpServletRequest.getRequestURI();
        String contextPath = httpServletRequest.getContextPath();
        String url = requestUri.substring(contextPath.length());
        if (excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
            return true;
        }
        Object user = httpServletRequest.getSession().getAttribute("LOGIN_USER");
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
