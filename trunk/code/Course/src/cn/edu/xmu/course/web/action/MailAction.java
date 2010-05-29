package cn.edu.xmu.course.web.action;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMailService;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ITeacherInfoService;

import com.googlecode.jsonplugin.annotations.JSON;

/**
 * 站内信操作
 * @author 何申密
 *
 */
@SuppressWarnings("unchecked")
public class MailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7887886471455615261L;

	private IMailService mailService; //负责站内信业务的接口
	private IStudentInfoService studentInfoService;//负责学生信息的接口
	private ITeacherInfoService teacherInfoService;//负责教师信息的接口
	private Mail mail; //站内信
	private Mail oldMail; //原有的站内信
	private UserInfo replyUser;//回复的发件人
	private List<Mail> mailList;//站内信列表
	private Integer mailId;//站内信ID
	private Integer studentId;//学生ID
	private String studentNo;//学号
	private String teacherNo;//老师工作号
	private int status;//站内信状态
	private String[] pmitemid;//单选框ID
	private String savetosentbox;//是否保存到发件箱
	private String result;//返回给JSON的结果
	private List rows;

	/**
	 * 查找本学院所有的老师
	 * 
	 * @return
	 */
	public String findAllTeachersBySchool() {
		rows = teacherInfoService.getTeaNameAndNumber(super.getStudent()
				.getUserInfo().getDepartment().getSchool());
		return SUCCESS;
	}

	/**
	 * 查找本系所有的学生
	 * 
	 * @return
	 */
	public String findAllStudentsByDepartment() {
		rows = studentInfoService.getStuNameAndNumber(super.getTeacher()
				.getUserInfo().getDepartment());
		return SUCCESS;
	}

	/**
	 * 根据学号查找学生
	 * 
	 * @return
	 */
	public String findStudentByStuNo() {
		String[] stuNos = studentNo.split(";");
		String number = stuNos[stuNos.length - 1];
		Student stu = studentInfoService.findByStudentNo(number);
		if (stu == null)
			this.result = null;
		else
			result = stu.getUserInfo().getName() + ";" + stu.getStudentNo();
		return SUCCESS;
	}

	/**
	 * 根据教师工作证号查找教师
	 * 
	 * @return
	 */
	public String findTeacherByTeaNo() {
		String[] teacherNos = getTeacherNo().split(";");
		String number = teacherNos[teacherNos.length - 1];
		Teacher tea = teacherInfoService.findTeacherByTeacherNo(number);
		if (tea == null)
			this.result = null;
		else
			result = tea.getUserInfo().getName() + ";" + tea.getTeacherNo();
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
	 *学生给老师发送一个新的消息
	 * 
	 * @return
	 */
	public String addNewMailByStu() {
		String[] teacherNos = getTeacherNo().split(";");
		String number = teacherNos[teacherNos.length - 1];
		Teacher tea = teacherInfoService.findTeacherByTeacherNo(number);
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getStudent().getUserInfo(), tea
					.getUserInfo());
		else
			return this.addNewMail(super.getStudent().getUserInfo(), tea
					.getUserInfo());
	}

	/**
	 * 教师给学生发送一个新的消息
	 * 
	 * @return
	 */
	public String addNewMailByTea() {
		String[] stuNos = studentNo.split(";");
		String number = stuNos[stuNos.length - 1];
		Student stu = studentInfoService.findByStudentNo(number);
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getTeacher().getUserInfo(),stu.getUserInfo());
		else
			return this.addNewMail(super.getTeacher().getUserInfo(),stu.getUserInfo());
	}

	public String goNewMailByStu() {
		return SUCCESS;
	}

	/**
	 * 学生回复教师信息
	 * 
	 * @return
	 */
	public String addReplyMailByStu() {
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getStudent().getUserInfo(), mail
					.getReceiver());
		else
			return this.addNewMail(super.getStudent().getUserInfo(), mail
					.getReceiver());
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
	public String addDraftByStu() {
		String[] teaNos = teacherNo.split(";");
		String number = teaNos[teaNos.length - 1];
		Teacher tea = teacherInfoService.findTeacherByTeacherNo(number);
		return this.addDraft(super.getStudent().getUserInfo(), tea
				.getUserInfo());
	}

	/**
	 * 添加草稿
	 * 
	 * @return
	 */
	public String addDraftByTea() {
		String[] stuNos = studentNo.split(";");
		String number = stuNos[stuNos.length - 1];
		Student stu = studentInfoService.findByStudentNo(number);
		return this.addDraft(super.getTeacher().getUserInfo(), stu
				.getUserInfo());
	}

	/**
	 * 添加回复消息到草稿
	 * 
	 * @return
	 */
	public String addReplyDraftByStu() {
		return this.addDraft(super.getStudent().getUserInfo(), mail
				.getReceiver());
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
	 * 
	 * @return
	 */
	public String deleteMail() {
		mail = mailService.getMailById(mailId);
		if (mailService.deleteMail(mail)) {
			addActionMessage("删除消息成功！");
			return SUCCESS;
		} else {
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
		if (mailService.deleteMails(pmitemid)) {
			addActionMessage("删除消息成功！");
			return SUCCESS;
		} else {
			addActionError("删除消息失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 学生查询收到的消息
	 * 
	 * @return
	 */
	public String getReceiveMailByStu() {
		mailList = mailService.getMailsByReceiver(super.getStudent()
				.getUserInfo());
		return SUCCESS;
	}

	/**
	 * 教师查询收到的消息
	 * 
	 * @return
	 */
	public String getReceiveMailByTea() {
		mailList = mailService.getMailsByReceiver(super.getTeacher()
				.getUserInfo());
		return SUCCESS;
	}

	/**
	 * 学生查询发送的消息
	 * 
	 * @return
	 */
	public String getSendMailByStu() {
		mailList = mailService.getMailsBySender(super.getStudent()
				.getUserInfo(), 1);
		return SUCCESS;
	}

	/**
	 * 教师查询发送的消息
	 * 
	 * @return
	 */
	public String getSendMailByTea() {
		mailList = mailService.getMailsBySender(super.getTeacher()
				.getUserInfo(), 1);
		return SUCCESS;
	}

	/**
	 * 学生查询草稿
	 * 
	 * @return
	 */
	public String getDraftByStu() {
		mailList = mailService.getMailsBySender(super.getStudent()
				.getUserInfo(), 2);
		return SUCCESS;
	}

	/**
	 * 教师查询草稿
	 * 
	 * @return
	 */
	public String getDraftByTea() {
		mailList = mailService.getMailsBySender(super.getTeacher()
				.getUserInfo(), 2);
		return SUCCESS;
	}

	/**
	 * 获取消息的详细内容
	 * 
	 * @return
	 */
	public String getMailDetail() {
		mail = mailService.updateMailStatus(mailId);
		if (mail == null) {
			addActionError("获取消息失败，请重新操作！");
			return ERROR;
		}
		this.result = mail.getContent();
		return SUCCESS;
	}

	/**
	 * 学生再次编辑草稿
	 * 
	 * @return
	 */
	public String goDraftDetailByStu() {

		mail = mailService.getMailById(mailId);
		Teacher tea = teacherInfoService.findTeacherByUserInfo(mail
				.getReceiver());
		if (tea != null)
			setTeacherNo(tea.getUserInfo().getName() + ";" + tea.getTeacherNo());
		return SUCCESS;
	}

	/**
	 * 教师再次编辑草稿
	 * 
	 * @return
	 */
	public String goDraftDetail() {
		mail = mailService.getMailById(mailId);
		Student stu = studentInfoService.findByUserInfo(mail.getReceiver());
		if (stu != null)
			studentNo = stu.getUserInfo().getName() + ";" + stu.getStudentNo();
		return SUCCESS;
	}

	/**
	 * 教师给学生发送站内信
	 * 
	 * @return
	 */
	public String goSendNewMailByTea() {
		Student stu = studentInfoService.findById(getStudentId());
		studentNo = stu.getUserInfo().getName() + ";" + stu.getStudentNo();
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

	@SuppressWarnings("unchecked")
	public void setRows(List rows) {
		this.rows = rows;
	}

	@SuppressWarnings("unchecked")
	@JSON(name = "rows")
	public List getRows() {
		return rows;
	}

	public void setTeacherInfoService(ITeacherInfoService teacherInfoService) {
		this.teacherInfoService = teacherInfoService;
	}

	public ITeacherInfoService getTeacherInfoService() {
		return teacherInfoService;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStudentId() {
		return studentId;
	}

}
