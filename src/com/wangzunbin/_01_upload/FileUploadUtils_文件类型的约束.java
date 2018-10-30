package com.wangzunbin._01_upload;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/newupload")
public class FileUploadUtils_文件类型的约束 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6225901979875491494L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 验证请求是否满足要求(post请求/enctype是否以multipart/打头)
		boolean isMulipart = ServletFileUpload.isMultipartContent(req);
		System.out.println(isMulipart);
		if (!isMulipart) {
			System.out.println("上传的数据有误");
			return;
		}
		try {
			FileUploadUtils.upload(req); 
		} catch (LogicException e) {
			req.setAttribute("errorMsg", e.getMessage());
			req.getRequestDispatcher("/upload/newregister.jsp").forward(req, resp);
		}
	}
}
