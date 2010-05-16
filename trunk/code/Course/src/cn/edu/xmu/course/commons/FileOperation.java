package cn.edu.xmu.course.commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperation {
	private static final int BUFFER_SIZE = 16 * 1024;
	private static FileOperation instance = new FileOperation();

	private FileOperation() {

	}

	public static FileOperation getFileOperation() {
		return instance;
	}

	/**
	 * 删除文件
	 * @param del
	 */
	public static void delete(File del) {
		if(del.exists())
			del.delete();
	}
	
	/**
	 * 复制文件
	 * @param src
	 * @param dst
	 * @return
	 * @throws Exception
	 */
	public static boolean copy(File src, File dst) throws Exception {
		if (!dst.getParentFile().exists()) {
			dst.getParentFile().mkdirs();
		}
		if(dst.exists())
			dst.delete();
		try {
			InputStream in = null;
			OutputStream out = null;
			try {				
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 删除文件夹下所有内容
	 * @param folderPath
	 * @return
	 */
	public static boolean delFolder(String folderPath) {
		try {
			delAllFile(folderPath);	
			String filePath = folderPath;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除指定文件夹下所有文件
	// param path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}	
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}
}
