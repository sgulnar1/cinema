package aze.coders.cinema.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

public class HeaderInterceptor implements HandlerInterceptor {
    public static final String HEADER_LANGUAGE = "Language";
    public static String LANGUAGE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LANGUAGE = request.getHeader(HEADER_LANGUAGE);
        return true;

    }
}
