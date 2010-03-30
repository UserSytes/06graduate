package cn.edu.xmu.course.web.action;

import java.util.List;

import com.googlecode.jsonplugin.annotations.JSON;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMailService;
import cn.edu.xmu.course.service.IStudentInfoService;

public class MailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7887886471455615261L;

	private IMailService mailService;
	private IStudentInfoService studentInfoService;
	private Mail mail;
	private Mail oldMail;
	private UserInfo replyUser;
	private List<Mail> mailList;
	private Integer mailId;
	private String studentNo;
	private int count;
	private int status;
	private String[] pmitemid;
	private String savetosentbox;
	private String result;

	/**
	 * 查找学生
	 * 
	 * @return
	 */
	public String findStudentByStuNo() {
		List<Mail> newMailList=mailService.getMailsByReceiver(super.getUserInfo());
		
		
		return SUCCESS;
	}

	/**
	 * 添加新的消息
	 * 
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public String addNewMail(UserInfo sender, UserInfo receiver) {
		if (mailService.addNewMail(mail, sender, receiver)) {
			addActionMessage("发送消息成功！");
			return SUCCESS;
		} else {
			addActionError("发送消息失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 发送并保存消息
	 * 
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public String addAndSaveMail(UserInfo sender, UserInfo receiver) {
		if (mailService.addAndSaveMail(mail, sender, receiver)) {
			addActionMessage("发送消息成功,消息已保存在发件箱！");
			return SUCCESS;
		} else {
			addActionError("发送消息失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 教师给学生发送一个新的消息
	 * 
	 * @return
	 */
	public String addNewMailByTea() {
		Student stu = studentInfoService.findByStudentNo(studentNo);
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getTeacher().getUserInfo(), stu
					.getUserInfo());
		else
			return this.addNewMail(super.getTeacher().getUserInfo(), stu
					.getUserInfo());
	}

	/**
	 * 教师回复消息
	 * 
	 * @return
	 */
	public String addReplyMailByTea() {
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getTeacher().getUserInfo(), mail
					.getReceiver());
		else
			return this.addNewMail(super.getTeacher().getUserInfo(), mail
					.getReceiver());
	}

	/**
	 * 添加草稿
	 * 
	 * @return
	 */
	public String addDraftByTea() {
		Student stu = studentInfoService.findByStudentNo(studentNo);
		return this.addDraft(super.getTeacher().getUserInfo(), stu
				.getUserInfo());
	}

	/**
	 * 添加回复消息到草稿
	 * 
	 * @return
	 */
	public String addReplyDraftByTea() {
		return this.addDraft(super.getTeacher().getUserInfo(), mail
				.getReceiver());
	}

	/**
	 * 将消息保存在草稿箱中
	 * 
	 * @return
	 */
	public String addDraft(UserInfo sender, UserInfo receiver) {
		if (mailService.addDraft(mail, sender, receiver)) {
			addActionMessage("已将消息保存在草稿箱！");
			return SUCCESS;
		} else {
			addActionError("保存消息失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除消息
	 * @return
	 */
	public String deleteMail(){
		mail = mailService.getMailById(mailId);
		if(mailService.deleteMail(mail)){
			addActionMessage("删除消息成功！");
			return SUCCESS;
		}			
		else {
			addActionError("删除消息失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 批量删除消息
	 * 
	 * @return
	 */
	public String deleteMails() {
		if(mailService.deleteMails(pmitemid)){
			addActionMessage("删除消息成功！");
			return SUCCESS;
		}
		else {
			addActionError("删除消息失败，请重新操作！");
			return ERROR;
		}
	}


	/**
	 * 教师查询收到的消息
	 * 
	 * @return
	 */
	public String getReceiveMailByTea() {
		mailList = mailService.getMailsByReceiver(super.getTeacher()
				.getUserInfo());
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * 教师查询发送的消息和草稿
	 * 
	 * @return
	 */
	public String getSendMailByTea() {
		mailList = mailService.getMailsBySender(super.getTeacher()
				.getUserInfo(), 1);
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * 教师查询发送的消息和草稿
	 * 
	 * @return
	 */
	public String getDraftByTea() {
		mailList = mailService.getMailsBySender(super.getTeacher()
				.getUserInfo(), 2);
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * 获取消息的详细内容
	 * 
	 * @return
	 */
	public String getMailDetail() {
		mail = mailService.updateMailStatus(mailId);
		if (mail == null){
			addActionError("获取消息失败，请重新操作！");
			return ERROR;
		}
		this.result = mail.getContent();
		return SUCCESS;
	}

	/**
	 * 再次编辑草稿
	 * 
	 * @return
	 */
	public String goDraftDetail() {
		mail = mailService.getMailById(mailId);
		Student stu = studentInfoService.findByUserInfo(mail.getReceiver());
		if (stu != null)
			studentNo = stu.getStudentNo();
		return SUCCESS;
	}

	/**
	 * 跳到回复消息页面
	 * 
	 * @return
	 */
	public String goReplyMail() {
		oldMail = mailService.getMailById(mailId);
		mail = new Mail();
		mail.setReceiver(oldMail.getSender());
		mail.setTitle("回复：" + oldMail.getTitle());
		mail.setContent("\n\n\n\n------------------ 原始邮件 ------------------\n>"
				+ oldMail.getContent());
		return SUCCESS;
	}
	/**
	 * 跳到回复消息页面
	 * 
	 * @return
	 */
	public String goReSendMail() {
		oldMail = mailService.getMailById(mailId);
		mail = new Mail();
		mail.setTitle("转发：" + oldMail.getTitle());
		mail.setContent("\n\n\n\n------------------ 原始邮件 ------------------\n>"
				+ oldMail.getContent());
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

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStudentInfoService(IStudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}

	public IStudentInfoService getStudentInfoService() {
		return studentInfoService;
	}

	public void setPmitemid(String[] pmitemid) {
		this.pmitemid = pmitemid;
	}

	public String[] getPmitemid() {
		return pmitemid;
	}

	public void setOldMail(Mail oldMail) {
		this.oldMail = oldMail;
	}

	public Mail getOldMail() {
		return oldMail;
	}

	public void setReplyUser(UserInfo replyUser) {
		this.replyUser = replyUser;
	}

	public UserInfo getReplyUser() {
		return replyUser;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setSavetosentbox(String savetosentbox) {
		this.savetosentbox = savetosentbox;
	}

	public String getSavetosentbox() {
		return savetosentbox;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

}
