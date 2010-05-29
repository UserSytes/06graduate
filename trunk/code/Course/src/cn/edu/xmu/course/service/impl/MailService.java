package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.MailDAO;
import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMailService;

/**
 * 站内信功能模块接口
 * @author 何申密
 *
 */
public class MailService implements IMailService {

	private MailDAO mailDAO;

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#addNewMail(cn.edu.xmu.course.pojo.Mail, cn.edu.xmu.course.pojo.UserInfo, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addNewMail(Mail mail, UserInfo sender, UserInfo receiver) {
		// TODO Auto-generated method stub
		mail.setSender(sender);
		mail.setReceiver(receiver);
		mail.setStatus(1);
		mail.setSort(1);
		mail.setTime(new Date());
		try {
			mailDAO.save(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#addDraft(cn.edu.xmu.course.pojo.Mail, cn.edu.xmu.course.pojo.UserInfo, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addDraft(Mail mail, UserInfo sender, UserInfo receiver) {
		// TODO Auto-generated method stub
		mail.setSender(sender);
		mail.setReceiver(receiver);
		mail.setStatus(2);
		mail.setSort(2);
		mail.setTime(new Date());
		try {
			mailDAO.save(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#addAndSaveMail(cn.edu.xmu.course.pojo.Mail, cn.edu.xmu.course.pojo.UserInfo, cn.edu.xmu.course.pojo.UserInfo)
	 */
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver) {
		// TODO Auto-generated method stub
		Mail saveMail = new Mail();
		saveMail.setContent(mail.getContent());
		saveMail.setTitle(mail.getTitle());
		saveMail.setReceiver(receiver);
		saveMail.setSender(sender);
		saveMail.setStatus(1);
		saveMail.setSort(2);
		saveMail.setTime(new Date());
		mail.setSender(sender);
		mail.setReceiver(receiver);
		mail.setStatus(1);
		mail.setSort(1);
		mail.setTime(new Date());
		try {
			mailDAO.save(saveMail);
			mailDAO.save(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#deleteMail(cn.edu.xmu.course.pojo.Mail)
	 */
	public boolean deleteMail(Mail mail) {
		// TODO Auto-generated method stub
		try {
			mailDAO.delete(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#getMailById(java.lang.Integer)
	 */
	public Mail getMailById(Integer id) {
		// TODO Auto-generated method stub
		return mailDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#getMailDetail(java.lang.Integer)
	 */
	public String getMailDetail(Integer id) {
		// TODO Auto-generated method stub
		return mailDAO.findById(id).getContent();
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#getMailsByReceiver(cn.edu.xmu.course.pojo.UserInfo)
	 */
	public List<Mail> getMailsByReceiver(UserInfo receiver) {
		// TODO Auto-generated method stub
		return mailDAO.findByReceiver(receiver);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#getMailsBySender(cn.edu.xmu.course.pojo.UserInfo, int)
	 */
	public List<Mail> getMailsBySender(UserInfo sender, int status) {
		// TODO Auto-generated method stub
		return mailDAO.findBySender(sender, status);
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#updateMail(cn.edu.xmu.course.pojo.Mail)
	 */
	public boolean updateMail(Mail mail) {
		// TODO Auto-generated method stub
		try {
			mailDAO.merge(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#deleteMails(java.lang.String[])
	 */
	public boolean deleteMails(String[] mailIds) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mailIds.length; i++) {
			Mail mail = this.getMailById(Integer.parseInt(mailIds[i]));
			try{				
				this.deleteMail(mail);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#updateMailStatus(java.lang.Integer)
	 */
	public Mail updateMailStatus(Integer id) {
		// TODO Auto-generated method stub
		Mail mail = this.getMailById(id);
		if (mail.getStatus() == 1 && mail.getSort() == 1) {
			mail.setStatus(0);
			try {
				mailDAO.merge(mail);
			} catch (Exception e) {
				return null;
			}
		} 
		return mail;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IMailService#updateMails(java.lang.String[], int)
	 */
	public boolean updateMails(String[] mailIds, int status) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < mailIds.length; i++) {
			Mail mail = this.getMailById(Integer.parseInt(mailIds[i]));
			mail.setStatus(status);
			try{				
				this.updateMail(mail);
			}catch(Exception e){
				return false;
			}
		}
		return true;
	}

	public void setMailDAO(MailDAO mailDAO) {
		this.mailDAO = mailDAO;
	}

	public MailDAO getMailDAO() {
		return mailDAO;
	}

}
