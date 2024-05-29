package com.example.buoi_1.repository.asm1;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.buoi_1.entity.UserSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();

        if (session != null) {
            UserSession userSession = (UserSession) session.getAttribute("userSession");
            if (userSession != null && userSession.isLoggedIn()) {
                String requestURI = request.getRequestURI();
                if ((requestURI.startsWith("/hoa-don") || requestURI.startsWith("/hoa-don-chi-tiet"))
                        && userSession.getRole().equals("USER")) {
                    request.setAttribute("accessDenied", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/alert");
                    dispatcher.forward(request, response);
                    return false;
                }
                return true;
            }
        }

        request.setAttribute("showLoginRequired", true);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
        dispatcher.forward(request, response);
        return false;
    }
}