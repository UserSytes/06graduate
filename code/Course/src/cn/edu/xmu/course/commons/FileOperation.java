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

	public static void delete(File del) {
		if(del.exists())
			del.delete();
	}
	
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
				System.out.println("the path is"+src.getPath());
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
			e.printStackTrace();
			throw e;
		}
		return true;
	}
}
