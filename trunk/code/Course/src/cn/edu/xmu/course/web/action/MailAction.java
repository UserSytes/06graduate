package cn.edu.xmu.course.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.googlecode.jsonplugin.annotations.JSON;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMailService;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ITeacherInfoService;

public class MailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7887886471455615261L;

	private IMailService mailService;
	private IStudentInfoService studentInfoService;
	private ITeacherInfoService teacherInfoService;
	private Mail mail;
	private Mail oldMail;
	private UserInfo replyUser;
	private List<Mail> mailList;
	private Integer mailId;
	private String studentNo;
	private String teacherNo;
	private int count;
	private int status;
	private String[] pmitemid;
	private String savetosentbox;
	private String result;
	private List rows = new ArrayList();

	public String findAllTeachersBySchool() {
		rows = teacherInfoService.getTeaNameAndNumber(super.getStudent()
				.getUserInfo().getDepartment().getSchool());
		return SUCCESS;
	}

	/**
	 * ����ѧ��
	 * 
	 * @return
	 */
	public String findAllStudentsByDepartment() {
		rows = studentInfoService.getStuNameAndNumber(super.getTeacher()
				.getUserInfo().getDepartment());
		return SUCCESS;
	}

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
	 * ����µ���Ϣ
	 * 
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public String addNewMail(UserInfo sender, UserInfo receiver) {
		if (mailService.addNewMail(mail, sender, receiver)) {
			addActionMessage("������Ϣ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ���Ͳ�������Ϣ
	 * 
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public String addAndSaveMail(UserInfo sender, UserInfo receiver) {
		if (mailService.addAndSaveMail(mail, sender, receiver)) {
			addActionMessage("������Ϣ�ɹ�,��Ϣ�ѱ����ڷ����䣡");
			return SUCCESS;
		} else {
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 *ѧ������ʦ����һ���µ���Ϣ
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
	 * ��ʦ��ѧ������һ���µ���Ϣ
	 * 
	 * @return
	 */
	public String addNewMailByTea() {
		String[] stuNos = studentNo.split(";");
		String number = stuNos[stuNos.length - 1];
		Teacher tea = teacherInfoService.findTeacherByTeacherNo(number);
		if (savetosentbox.equals("true"))
			return this.addAndSaveMail(super.getStudent().getUserInfo(), tea
					.getUserInfo());
		else
			return this.addNewMail(super.getStudent().getUserInfo(), tea
					.getUserInfo());
	}

	/**
	 * ��ʦ�ظ���Ϣ
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
	 * ��Ӳݸ�
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
	 * ��ӻظ���Ϣ���ݸ�
	 * 
	 * @return
	 */
	public String addReplyDraftByTea() {
		return this.addDraft(super.getTeacher().getUserInfo(), mail
				.getReceiver());
	}

	/**
	 * ����Ϣ�����ڲݸ�����
	 * 
	 * @return
	 */
	public String addDraft(UserInfo sender, UserInfo receiver) {
		if (mailService.addDraft(mail, sender, receiver)) {
			addActionMessage("�ѽ���Ϣ�����ڲݸ��䣡");
			return SUCCESS;
		} else {
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ����Ϣ
	 * 
	 * @return
	 */
	public String deleteMail() {
		mail = mailService.getMailById(mailId);
		if (mailService.deleteMail(mail)) {
			addActionMessage("ɾ����Ϣ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("ɾ����Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ����ɾ����Ϣ
	 * 
	 * @return
	 */
	public String deleteMails() {
		if (mailService.deleteMails(pmitemid)) {
			addActionMessage("ɾ����Ϣ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("ɾ����Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ѧ����ѯ�յ�����Ϣ
	 * 
	 * @return
	 */
	public String getReceiveMailByStu() {
		mailList = mailService.getMailsByReceiver(super.getStudent()
				.getUserInfo());
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * ��ʦ��ѯ�յ�����Ϣ
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
	 * ѧ����ѯ���͵���Ϣ
	 * 
	 * @return
	 */
	public String getSendMailByStu() {
		mailList = mailService.getMailsBySender(super.getStudent()
				.getUserInfo(), 1);
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * ��ʦ��ѯ���͵���Ϣ
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
	 * ѧ����ѯ�ݸ�
	 * 
	 * @return
	 */
	public String getDraftByStu() {
		mailList = mailService.getMailsBySender(super.getStudent()
				.getUserInfo(), 2);
		count = mailList.size();
		return SUCCESS;
	}

	/**
	 * ��ʦ��ѯ�ݸ�
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
	 * ��ȡ��Ϣ����ϸ����
	 * 
	 * @return
	 */
	public String getMailDetail() {
		mail = mailService.updateMailStatus(mailId);
		if (mail == null) {
			addActionError("��ȡ��Ϣʧ�ܣ������²�����");
			return ERROR;
		}
		this.result = mail.getContent();
		return SUCCESS;
	}

	/**
	 * ѧ���ٴα༭�ݸ�
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
	 * ��ʦ�ٴα༭�ݸ�
	 * 
	 * @return
	 */
	public String goDraftDetail() {
		rows = studentInfoService.getStuNameAndNumber(super.getTeacher()
				.getUserInfo().getDepartment());
		mail = mailService.getMailById(mailId);
		Student stu = studentInfoService.findByUserInfo(mail.getReceiver());
		if (stu != null)
			studentNo = stu.getUserInfo().getName() + ";" + stu.getStudentNo();
		System.out.println(studentNo);
		return SUCCESS;
	}

	/**
	 * �����ظ���Ϣҳ��
	 * 
	 * @return
	 */
	public String goReplyMail() {
		oldMail = mailService.getMailById(mailId);
		mail = new Mail();
		mail.setReceiver(oldMail.getSender());
		mail.setTitle("�ظ���" + oldMail.getTitle());
		mail.setContent("\n\n\n\n------------------ ԭʼ�ʼ� ------------------\n>"
				+ oldMail.getContent());
		return SUCCESS;
	}

	/**
	 * �����ظ���Ϣҳ��
	 * 
	 * @return
	 */
	public String goReSendMail() {
		oldMail = mailService.getMailById(mailId);
		mail = new Mail();
		mail.setTitle("ת����" + oldMail.getTitle());
		mail.setContent("\n\n\n\n------------------ ԭʼ�ʼ� ------------------\n>"
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

	public void setRows(List rows) {
		this.rows = rows;
	}

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

}
