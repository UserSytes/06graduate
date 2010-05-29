package cn.edu.xmu.course.web.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件下载
 *
 */
public class DownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7755086887552074756L;
	private final static String DOWNLOADFILEPATH = "/upload/";
	private String fileName;
	private String originalFileName;

	public void setFileName() {
		// 得到请求下载的文件名
		String fname = fileName;
		String forginalFileName = originalFileName;
		try {
			/*
			 * 对参数进行UTF-8解码,注意:实际进行UTF-8解码时会使用本地编码，本机为GBK。
			 * 这里使用request.setCharacterEncoding解码无效.
			 * 只有解码了getDownloadFile()方法才能在下载目录下正确找到请求的文件
			 */			
			 fname = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
			 forginalFileName =new
			 String(forginalFileName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.fileName = fname;
		this.originalFileName = forginalFileName;
	}

	/**
	 * @getFileName 此方法对应的是struts.xml文件中的： <param
	 * name="contentDisposition">attachment;filename="${fileName}"</param>
	 * 
	 * 这个属性设置的是下载工具下载文件时显示的文件名， 要想正确的显示中文文件名，我们需要对fileName再次编码
	 * 否则中文名文件将出现乱码，或无法下载的情况
	 */
	public String getFileName() throws UnsupportedEncodingException {

		fileName = new String(fileName.getBytes(), "ISO-8859-1");

		return fileName;
	}

	// 从下载文件原始存放路径读取得到文件输出流
	public InputStream getDownloadFile() {
		this.setFileName();
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload/");
		return ServletActionContext.getServletContext().getResourceAsStream(
				DOWNLOADFILEPATH + fileName);
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getOriginalFileName() throws UnsupportedEncodingException {
		originalFileName = new String(originalFileName.getBytes(), "ISO-8859-1");
		return originalFileName;
	}

}
