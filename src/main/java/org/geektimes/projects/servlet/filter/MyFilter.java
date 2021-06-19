package org.geektimes.projects.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * {@link Filter} 实现
 *
 * @author: Yu
 * @since: 1.0
 */
public class MyFilter implements Filter {
    /**
     * Filter 的生命周期之初始化
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter 加载成功。。。");
    }
    /**
     *  Filter 的生命周期过滤
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter 调用成功。。。");
        chain.doFilter(request,response);
    }
    /**
     *  Filter 的生命周期销毁
     */
    @Override
    public void destroy() {

    }
}
