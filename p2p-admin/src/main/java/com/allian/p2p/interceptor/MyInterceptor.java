package com.allian.p2p.interceptor;

import com.allian.p2p.commons.Constans;
import com.allian.p2p.model.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 秃头小岩
 * Ian
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        Map<String, String[]> paramMap = request.getParameterMap();
        StringBuilder stringBuilder  = new StringBuilder("?");
        for (String s : paramMap.keySet()) {
            stringBuilder.append(s).append("=").append(paramMap.get(s)[0]).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        String url = path+stringBuilder;
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Constans.USER);
        final Map<String, String> urlMap = userInfo.getUrlMap();
        if (!urlMap.containsKey(url)&&!urlMap.containsKey(path)){
            request.getRequestDispatcher("/permissionError").forward(request,response);
            return false;
        }
        return true;
    }
}
