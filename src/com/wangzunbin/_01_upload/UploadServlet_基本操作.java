package com.wangzunbin._01_upload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用map封装请求信息(不必要)
 * @author Administrator
 *
 */
public class UploadServlet_基本操作 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2696680127136056724L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User user = new User();
		Map<String, Object> map = new HashMap();
		System.out.println(map);
		try {
			FileUploadUtils.upload(req);
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
