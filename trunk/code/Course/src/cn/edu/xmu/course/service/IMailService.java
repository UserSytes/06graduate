package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;

public interface IMailService {

	public boolean addNewMail(Mail mail, UserInfo sender, UserInfo receiver);

	public boolean addDraft(Mail mail, UserInfo sender, UserInfo receiver);
	
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver);
	
	public boolean deleteMail(Mail mail);
	
	public String getMailDetail(Integer id);

	public Mail getMailById(Integer id);

	public Mail updateMailStatus(Integer id);
	
	public boolean deleteMails(String[] mailIds);
	
	public boolean updateMails(String[] mailIds, int status);
	
	public List getMailsByReceiver(UserInfo receiver);

	public List getMailsBySender(UserInfo sender, int status);

	public boolean updateMail(Mail mail);
}
