package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;

/**
 * 站内信功能模块接口
 * @author 何申密
 *
 */
public interface IMailService {

	/**
	 * 添加新的站内信
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addNewMail(Mail mail, UserInfo sender, UserInfo receiver);

	/**
	 * 添加站内信草稿
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addDraft(Mail mail, UserInfo sender, UserInfo receiver);
	
	/**
	 * 添加并保存站内信
	 * @param mail
	 * @param sender
	 * @param receiver
	 * @return
	 */
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver);
	
	/**
	 * 删除站内信
	 * @param mail
	 * @return
	 */
	public boolean deleteMail(Mail mail);
	
	/**
	 * 查看站内信详细内容
	 * @param id
	 * @return
	 */
	public String getMailDetail(Integer id);

	/**
	 * 根据ID获得站内信
	 * @param id
	 * @return
	 */
	public Mail getMailById(Integer id);

	/**
	 * 更改站内信已读或未读状态
	 * @param id
	 * @return
	 */
	public Mail updateMailStatus(Integer id);
	
	/**
	 * 批量删除站内信
	 * @param mailIds
	 * @return
	 */
	public boolean deleteMails(String[] mailIds);
	
	/**
	 * 批量更新站内信状态
	 * @param mailIds
	 * @param status
	 * @return
	 */
	public boolean updateMails(String[] mailIds, int status);
	
	/**
	 * 查看收件箱
	 * @param receiver
	 * @return
	 */
	public List<Mail> getMailsByReceiver(UserInfo receiver);

	/**
	 * 查看发件箱
	 * @param sender
	 * @param status
	 * @return
	 */
	public List<Mail> getMailsBySender(UserInfo sender, int status);

	/**
	 * 更新站内信
	 * @param mail
	 * @return
	 */
	public boolean updateMail(Mail mail);
}
