package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * վ���Ź���ģ��ӿ�
 * @author ������
 *
 */
public interface IMailService {

	/**
	 * ����µ�վ����
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addNewMail(Mail mail, UserInfo sender, UserInfo receiver);

	/**
	 * ���վ���Ųݸ�
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addDraft(Mail mail, UserInfo sender, UserInfo receiver);
	
	/**
	 * ��Ӳ�����վ����
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver);
	
	/**
	 * ɾ��վ����
	 * @param mail
	 * @return
	 */
	public boolean deleteMail(Mail mail);
	
	/**
	 * �鿴վ������ϸ����
	 * @param id
	 * @return
	 */
	public String getMailDetail(Integer id);

	/**
	 * ����ID���վ����
	 * @param id
	 * @return
	 */
	public Mail getMailById(Integer id);

	/**
	 * ����վ�����Ѷ���δ��״̬
	 * @param id
	 * @return
	 */
	public Mail updateMailStatus(Integer id);
	
	/**
	 * ����ɾ��վ����
	 * @param mailIds
	 * @return
	 */
	public boolean deleteMails(String[] mailIds);
	
	/**
	 * ��������վ����״̬
	 * @param mailIds
	 * @param status
	 * @return
	 */
	public boolean updateMails(String[] mailIds, int status);
	
	/**
	 * �鿴�ռ���
	 * @param receiver
	 * @return
	 */
	public List<Mail> getMailsByReceiver(UserInfo receiver);

	/**
	 * �鿴������
	 * @param sender
	 * @param status
	 * @return
	 */
	public List<Mail> getMailsBySender(UserInfo sender, int status);

	/**
	 * ����վ����
	 * @param mail
	 * @return
	 */
	public boolean updateMail(Mail mail);
}
