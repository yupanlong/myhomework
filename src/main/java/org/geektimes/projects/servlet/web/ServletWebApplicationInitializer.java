package org.geektimes.projects.servlet.web;

import org.geektimes.projects.servlet.JumpServlet;
import org.geektimes.projects.servlet.filter.MyFilter;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.WebServlet;
import java.util.Set;

/**
 * {@link ServletContainerInitializer} 实现
 * 通过SPI方式加载 ServletWebApplicationInitializer
 * @author: Yu
 * @since: 1.0
 */
@HandlesTypes(WebServlet.class)
public class ServletWebApplicationInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("ServletWebApplicationInitializer 加载成功。。。");
        // 编码方式添加Filter
        FilterRegistration.Dynamic myFilter = ctx.addFilter("MyFilter", MyFilter.class);
        myFilter.addMappingForUrlPatterns(null,true,"/myServlet");
        ServletRegistration jumpServlet = ctx.addServlet("jumpServlet", JumpServlet.class);
        jumpServlet.addMapping("/jumpServlet");

    }
}
