package com.wangzunbin._01_upload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


@WebServlet("/filename")
public class FileNameUtilsDemo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4705132118595687337L;

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
			// 创建fileitem实际上就是表单中的每一个表元素的封装
			// 创建一个fileitem的工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建一个文件上传处理器(装饰设计模式)
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				// 判断空间是否是普通控件
				if (fileItem.isFormField()) {
					
				}else {
					// 后面一截是获取得是文件的后缀名(就是文件的属性)
					String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileItem.getName());
					// java.io.FileNotFoundException: (拒绝访问。)  win10没有权限, 要放在除了C盘之外的
					fileItem.write(new File("d:/", fileName));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
