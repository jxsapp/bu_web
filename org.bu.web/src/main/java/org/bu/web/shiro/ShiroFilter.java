/**
 * 
 */
package org.bu.web.shiro;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroFilter implements Filter {

	@Autowired
	private ShiroService shiroService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Principal principal = httpRequest.getUserPrincipal();

		if (principal != null) {
			Subject subjects = SecurityUtils.getSubject();
			// 为了简单，这里初始化一个用户。实际项目项目中应该去数据库里通过名字取用户：
			// 例如：
			ShiroUser user = shiroService.getByAccount(principal.getName());

			if (user.getName().equals(principal.getName())) {
				UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
				subjects = SecurityUtils.getSubject();
				subjects.login(token);
				subjects.getSession();
			} else {
				// 如果用户为空，则subjects信息登出
				if (subjects != null) {
					subjects.logout();
				}
			}
		}
		chain.doFilter(httpRequest, httpResponse);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
