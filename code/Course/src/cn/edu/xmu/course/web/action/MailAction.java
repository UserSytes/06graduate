package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.service.IMailService;
import cn.edu.xmu.course.service.IStudentInfoService;

public class MailAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7887886471455615261L;
	
	private IMailService mailService;
	private IStudentInfoService studentService;
	private Mail mail;
	private List<Mail> mailList;
	private Integer mailId;
	private String studentNo;
	private int sort;
	private int status;
	
	/**
	 * ��ʦ��ѧ������һ���µ���Ϣ
	 * @return
	 */
	public String addNewMailByTeacher(){
		Student student = studentService.findByStudentNo(studentNo);
		
		if(mailService.addNewMail(mail, super.getTeacher().getUserInfo(), student.getUserInfo())){
			addActionMessage("������Ϣ�ɹ���");
			return SUCCESS;
		}else{
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ����Ϣ�����ڲݸ�����
	 * @return
	 */
	public String addDraftByTeacher(){
		Student student = studentService.findByStudentNo(studentNo);		
		if(mailService.addDraft(mail, super.getTeacher().getUserInfo(), student.getUserInfo())){
			addActionMessage("�ѽ���Ϣ�����ڲݸ��䣡");
			return SUCCESS;
		}else{
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ɾ����Ϣ
	 * @return
	 */
	public String deleteMailByTeacher(){
		mail = mailService.getMailById(mailId);
		if(mailService.deleteMail(mail))
			return SUCCESS;
		else{
			addActionError("ɾ����Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ��ʦ��ѯ�յ�����Ϣ
	 * @return
	 */
	public String getReceiveMailByTea(){
		mailList = mailService.getMailsByReceiver(super.getTeacher().getUserInfo());
		return SUCCESS;
	}
	
	/**
	 * ��ʦ��ѯ���͵���Ϣ�Ͳݸ�
	 * @return
	 */
	public String getSendMailListByTea(){
		mailList = mailService.getMailsBySender(super.getTeacher().getUserInfo(), getStatus());
		return SUCCESS;
	}
	
	public IMailService getMailService() {
		return mailService;
	}
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}
	public Mail getMail() {
		return mail;
	}
	public void setMail(Mail mail) {
		this.mail = mail;
	}
	public List<Mail> getMailList() {
		return mailList;
	}
	public void setMailList(List<Mail> mailList) {
		this.mailList = mailList;
	}
	public Integer getMailId() {
		return mailId;
	}
	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentService(IStudentInfoService studentService) {
		this.studentService = studentService;
	}

	public IStudentInfoService getStudentService() {
		return studentService;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return sort;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	
	
}
