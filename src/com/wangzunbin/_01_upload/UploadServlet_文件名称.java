package com.wangzunbin._01_upload;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * servlet3.0支持文件上传
 * @author Administrator
 *
 */
@WebServlet("/uploadAnno")
public class UploadServlet_文件名称 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6267996930613951911L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		// 和fileItem类似
		Part part = req.getPart("headImg1");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		String[] contents = part.getHeader("Content-Disposition").split(";");
		String fileName = contents[2].substring(" filename=\\".length(), contents[2].length() - 1);
		String realPath = req.getServletContext().getRealPath("/upload/images");
		System.out.println(realPath);
		part.write(realPath + "\\" + fileName);
	}
}
