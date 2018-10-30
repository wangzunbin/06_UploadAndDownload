package com.wangzunbin._01_upload;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileUploadUtils {

	public static void upload(HttpServletRequest req) throws LogicException {
		try {
			// 创建fileitem实际上就是表单中的每一个表元素的封装
			// 创建一个fileitem的工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 创建一个文件上传处理器(装饰设计模式)
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			List<FileItem> items = upload.parseRequest(req);
			// 单个文件大小不能超过50kb
			upload.setSizeMax(1024 * 50);
//			upload.setFileSizeMax(1024 * 50);
			for (FileItem fileItem : items) {
				// 判断空间是否是普通控件
				if (fileItem.isFormField()) {

				} else {
					String contentType = fileItem.getContentType();
					if (!contentType.startsWith("image/")) {
						throw new LoginException("亲, 您的文件格式不正确");
					}
					// 后面一截是获取得是文件的后缀名(就是文件的属性)
					String fileName = UUID.randomUUID().toString() + "."
							+ FilenameUtils.getExtension(fileItem.getName());
					// java.io.FileNotFoundException: (拒绝访问。) win10没有权限, 要放在除了C盘之外的
					fileItem.write(new File("d:/", fileName));
				}
			}
		} catch (FileSizeLimitExceededException e) {
			throw new LogicException("亲, 您的文件大小超过了500kb", e);
		} catch (LogicException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
