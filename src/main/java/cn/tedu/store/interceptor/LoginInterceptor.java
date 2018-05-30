package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 設置攔截器
 * 
 * @author TEDU.TW
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 響應完視圖之後執行的方法
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 執行業務方法之後，但是在return視圖之前執行的
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 在控制器執行方法之前執行 登入攔截器在執行業務層方法之前執行 情況:沒登入過，就直接跳轉到登錄頁面上。
	 */
	public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object obj) throws Exception {
		// 1.判斷session user是否為空
		HttpSession session = Request.getSession();// 從Request取得session
		obj = session.getAttribute("user");// 再從session取得user
		// 2.如果是空，重定向到Login的頁面上。
		if (obj == null) {
			String url = Request.getContextPath() + "/user/showLogin.do";
			Response.sendRedirect(url);
			return false;
		} else {
			// 3.若不為空繼續執行controller方法。
			return true;
		}
	}

}
