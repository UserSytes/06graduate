package cn.edu.xmu.course.web.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ�����
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
		// �õ��������ص��ļ���
		String fname = fileName;
		String forginalFileName = originalFileName;
		try {
			/*
			 * �Բ�������UTF-8����,ע��:ʵ�ʽ���UTF-8����ʱ��ʹ�ñ��ر��룬����ΪGBK��
			 * ����ʹ��request.setCharacterEncoding������Ч.
			 * ֻ�н�����getDownloadFile()��������������Ŀ¼����ȷ�ҵ�������ļ�
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
	 * @getFileName �˷�����Ӧ����struts.xml�ļ��еģ� <param
	 * name="contentDisposition">attachment;filename="${fileName}"</param>
	 * 
	 * ����������õ������ع��������ļ�ʱ��ʾ���ļ����� Ҫ����ȷ����ʾ�����ļ�����������Ҫ��fileName�ٴα���
	 * �����������ļ����������룬���޷����ص����
	 */
	public String getFileName() throws UnsupportedEncodingException {

		fileName = new String(fileName.getBytes(), "ISO-8859-1");

		return fileName;
	}

	// �������ļ�ԭʼ���·����ȡ�õ��ļ������
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
