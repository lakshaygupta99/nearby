package com.nearby.backend.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class NearbyInterceptor implements HandlerInterceptor {
   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
	   
      
//      if(request.getHeader("key").equals("password"))
//    	return true;
//      else {
//    	  response.setStatus(401);
//    	  response.getWriter().write("You are NOT Authorized for the req");
//    	  return false;
//      }
      
      return true;
   }
//   @Override
//   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
//      Object handler, ModelAndView modelAndView) throws Exception {
//      
//      System.out.println("Post Handle method is Calling");
//   }
}