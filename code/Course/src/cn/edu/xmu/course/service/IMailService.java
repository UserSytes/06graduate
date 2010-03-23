package cn.edu.xmu.course.service;

import java.util.List;

import cn.edu.xmu.course.pojo.Mail;
import cn.edu.xmu.course.pojo.UserInfo;

public interface IMailService {

	public boolean addNewMail(Mail mail, UserInfo sender, UserInfo receiver);

	public boolean addDraft(Mail mail, UserInfo sender, UserInfo receiver);
	
	public boolean addAndSaveMail(Mail mail, UserInfo sender, UserInfo receiver);
	
	public boolean deleteMail(Mail mail);

	public Mail getMailById(Integer id);

	public List getMailsByReceiver(UserInfo receiver);

	public List getMailsBySender(UserInfo sender, int status);

	public boolean updateMail(Mail mail);
}
