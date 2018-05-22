package bitcamp.java106.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    FilterConfig config;
    String encoding = "UTF-8";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        System.out.println("Filter적용!!");
        if (config.getInitParameter("encoding") != null) {
            this.encoding = config.getInitParameter("encoding");
        }
    }
            
    @Override
    public void destroy() {
    }
            
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 서블릿을 실행하기 전에 클라이언트가 보낸 데이터에 대해 문자표를 지정한다.
        System.out.println("Filter!!!!!!!!!!!!!!!");
        request.setCharacterEncoding(this.encoding);
        
        chain.doFilter(request, response);
    }
}
