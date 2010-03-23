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
	 * 教师给学生发送一个新的消息
	 * @return
	 */
	public String addNewMailByTeacher(){
		Student student = studentService.findByStudentNo(studentNo);
		
		if(mailService.addNewMail(mail, super.getTeacher().getUserInfo(), student.getUserInfo())){
			addActionMessage("发送消息成功！");
			return SUCCESS;
		}else{
			addActionError("发送消息失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 将消息保存在草稿箱中
	 * @return
	 */
	public String addDraftByTeacher(){
		Student student = studentService.findByStudentNo(studentNo);		
		if(mailService.addDraft(mail, super.getTeacher().getUserInfo(), student.getUserInfo())){
			addActionMessage("已将消息保存在草稿箱！");
			return SUCCESS;
		}else{
			addActionError("保存消息失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 删除消息
	 * @return
	 */
	public String deleteMailByTeacher(){
		mail = mailService.getMailById(mailId);
		if(mailService.deleteMail(mail))
			return SUCCESS;
		else{
			addActionError("删除消息失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 教师查询收到的消息
	 * @return
	 */
	public String getReceiveMailByTea(){
		mailList = mailService.getMailsByReceiver(super.getTeacher().getUserInfo());
		return SUCCESS;
	}
	
	/**
	 * 教师查询发送的消息和草稿
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
