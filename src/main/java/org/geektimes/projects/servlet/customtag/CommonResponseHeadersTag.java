package org.geektimes.projects.servlet.customtag;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * TODO
 *
 * @author Yu
 * @since 1.0
 */

public class CommonResponseHeadersTag extends SimpleTagSupport {
    private String cacheControl;
    private String pragma;
    private Long expires;

    public void setMessage(String cacheControl) {
        this.cacheControl = cacheControl;
    }
    public void setPragma(String pragma) {
        this.pragma = pragma;
    }
    public void setExpires(Long expires) {
        this.expires = expires;
    }
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) this.getJspContext();
        HttpServletResponse response = (HttpServletResponse)pageContext.getResponse();
           response.setHeader("Cache-Control",cacheControl);
           response.setHeader("Pragma",pragma);
           response.setHeader("Expires", String.valueOf(expires));
    }
}
