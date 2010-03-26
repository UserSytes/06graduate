package cn.edu.xmu.course.service.impl;

import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.dao.MailDAO;
import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMailService;

public class MailService implements IMailService {

	private MailDAO mailDAO;

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
	
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver) {
		// TODO Auto-generated method stub
		Mail saveMail = new Mail();
		saveMail.setContent(mail.getContent());
		saveMail.setTitle(mail.getTitle());
		saveMail.setSender(receiver);
		saveMail.setReceiver(sender);
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

	public boolean deleteMail(Mail mail) {
		// TODO Auto-generated method stub
		try {
			mailDAO.delete(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Mail getMailById(Integer id) {
		// TODO Auto-generated method stub
		return mailDAO.findById(id);
	}
	
	public String getMailDetail(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("here");
		return mailDAO.findById(id).getContent();
	}

	public List getMailsByReceiver(UserInfo receiver) {
		// TODO Auto-generated method stub
		return mailDAO.findByReceiver(receiver);
	}

	public List getMailsBySender(UserInfo sender, int status) {
		// TODO Auto-generated method stub
		return mailDAO.findBySender(sender, status);
	}

	public boolean updateMail(Mail mail) {
		// TODO Auto-generated method stub
		try {
			mailDAO.merge(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setMailDAO(MailDAO mailDAO) {
		this.mailDAO = mailDAO;
	}

	public MailDAO getMailDAO() {
		return mailDAO;
	}




}
