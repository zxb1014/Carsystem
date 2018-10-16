package com.yaohao.util;

import java.io.File;
import java.net.InetAddress;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	public static String path = "F:/developer/apache-tomcat-8.5.34/webapps/ROOT/imge/";
	public static String  url="http://localhost:8081/imge/";


	public static String upload(MultipartFile file) throws Exception {
		// 使用原文件名
		String realPath = path + file.getOriginalFilename();

		File dest = new File(realPath);

		// 判断文件父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest);
			return url + file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
}
