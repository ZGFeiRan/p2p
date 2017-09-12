package cn.p2p.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.p2p.pojo.Member;
import cn.p2p.util.Constant;

/**
 * 验证用户是否登录
 * 
 * @author 117
 *
 */
public class LoginInterceptors implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		Member member = (Member) request.getSession().getAttribute(Constant.USER_SESSION);
		if (null == member) {
			response.sendRedirect("/p2p/goLogin");
			return false;
		}
		return true;
	}

}
