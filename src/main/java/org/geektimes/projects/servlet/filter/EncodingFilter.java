package org.geektimes.projects.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * {@link Filter} 实现
 *
 * @author : Yu
 * @since : 1.0
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    /**
     * Filter 的生命周期之初始化
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *  Filter 的生命周期之服务
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 此操作是必须 否则会在此中断 不会到流转到下个Filter or Servlet
        chain.doFilter(request,response);
    }
    /**
     *  Filter 的生命周期之销毁
     */
    @Override
    public void destroy() {

    }
}
