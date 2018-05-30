package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * �]�m�d�I��
 * 
 * @author TEDU.TW
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * �T�������Ϥ�����檺��k
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * ����~�Ȥ�k����A���O�breturn���Ϥ��e���檺
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * �b��������k���e���� �n�J�d�I���b����~�ȼh��k���e���� ���p:�S�n�J�L�A�N���������n�������W�C
	 */
	public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object obj) throws Exception {
		// 1.�P�_session user�O�_����
		HttpSession session = Request.getSession();// �qRequest���osession
		obj = session.getAttribute("user");// �A�qsession���ouser
		// 2.�p�G�O�šA���w�V��Login�������W�C
		if (obj == null) {
			String url = Request.getContextPath() + "/user/showLogin.do";
			Response.sendRedirect(url);
			return false;
		} else {
			// 3.�Y�������~�����controller��k�C
			return true;
		}
	}

}
