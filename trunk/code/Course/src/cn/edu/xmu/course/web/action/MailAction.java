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

	public String findStudentByStuNo() {
		Student stu = studentInfoService.findByStudentNo(studentNo);
		if (stu == null)
			this.result = null;
		else
			this.result = stu.getUserInfo().getName();
		return SUCCESS;
	}

	public String addNewMail(UserInfo sender, UserInfo receiver) {
		if (mailService.addNewMail(mail, sender, receiver)) {
			addActionMessage("������Ϣ�ɹ���");
			return SUCCESS;
		} else {
			addActionError("������Ϣʧ�ܣ������²�����");
			return ERROR;
		}
	}

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
	 * ��ʦ��ѧ������һ���µ���Ϣ
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
		Student stu = studentInfoService.findByStudentNo(studentNo);
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
	public String deleteMailByTeacher() {
		// mail = mailService.getMailById(mailId);
		System.out.println(pmitemid.length);
		for (int i = 0; i < pmitemid.length; i++) {
			System.out.println("��õ�id��: " + pmitemid[i]);
		}
		// if(mailService.deleteMail(mail))
		// return SUCCESS;
		// else{
		// addActionError("ɾ����Ϣʧ�ܣ������²�����");
		// return ERROR;
		// }
		return SUCCESS;
	}

	/**
	 * ����ż���״̬
	 * 
	 * @return
	 */
	public String updateMailStatusByTea() {
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
	 * ��ʦ��ѯ���͵���Ϣ�Ͳݸ�
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
	 * ��ʦ��ѯ���͵���Ϣ�Ͳݸ�
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
		mail = mailService.getMailById(mailId);
		this.result = mail.getContent();
		// ����ż���״̬
		return SUCCESS;
	}
	
	/**
	 * �ٴα༭�ݸ�
	 * @return
	 */
	public String goDraftDetail() {
		mail = mailService.getMailById(mailId);
		Student stu = studentInfoService.findByUserInfo(mail.getReceiver());
		if(stu!= null)
			studentNo = stu.getStudentNo();
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
