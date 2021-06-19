package org.geektimes.projects.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * {@link ServletContextListener} 实现
 *  ServletContext 的监听事件
 * @author: Yu
 * @since: 1.0
 */
@WebListener("ServletContext 的监听事件Demo")
public class MyServletContextListener implements ServletContextListener {
    /**
     * 在ServletContext 初始化完成之后 调用
     * @param sce 事件
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        // 获取web.xml 中配置的ServletContext的初始化参数
        String initParameter = servletContext.getInitParameter("application.name");
        System.out.println(initParameter);
    }

    /**
     * 在ServletContext 销毁的时候调用
     * @param sce 事件
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("myServletContextListener 销毁。。。");
    }
}
