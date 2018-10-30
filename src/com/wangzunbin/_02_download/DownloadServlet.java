package com.wangzunbin._02_download;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2407262461424046786L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应数据的MIME类型
		resp.setContentType("application/x-msdownload");
		// 获取文件名称
		String fileName = req.getParameter("filename");
		// 判断浏览器是否是IE
		String userAgent = req.getHeader("User-Agent");
		if (userAgent.contains("MSIE")) {
			// IE 
			resp.setHeader("Content-Disposition", "attachment; filename=" 
			+ URLEncoder.encode(fileName, "UTF-8"));
		} else {
			// 非IE
			resp.setHeader("Content-Disposition", "attachment; filename=" 
			+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
		}
		
		// 获取文件所在的路径
		String path = req.getServletContext().getRealPath("/WEB-INF/download");
		// 获取指定的文件对象
		File file = new File(path, fileName);
		ServletOutputStream out = resp.getOutputStream();
		// 将文件复制到输出流中, 响应给浏览器
		Files.copy(Paths.get(file.getAbsolutePath()), out);
		
	}
}
