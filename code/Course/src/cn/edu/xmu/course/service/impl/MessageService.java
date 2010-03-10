package cn.edu.xmu.course.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.edu.xmu.course.commons.CompareTime;
import cn.edu.xmu.course.commons.MessageInfo;
import cn.edu.xmu.course.dao.MessageDAO;
import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.Message;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Topic;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IMessageService;

public class MessageService implements IMessageService {
	private MessageDAO messageDAO;
	
	public boolean addMessage(Topic topic, Message message) {
		System.out.println("正在加入帖子为："+topic.getId()+"的留言");
		message.setTopic(topic);
		message.setTime(new Date());
		try {
			messageDAO.save(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteMessage(Message message) {
		try {
			messageDAO.delete(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List getAllMessages(Topic topic) {
		List<MessageInfo> messageInfoList=new ArrayList();	
		List list = messageDAO.findByTopic(topic);
		Iterator it=list.iterator();
		if (list.size() > 0) {
			CompareTime c = new CompareTime();
			Collections.sort(list, c);
			it=list.iterator();		
			while(it.hasNext())
			{
				MessageInfo temp=new MessageInfo();
				Message m=(Message)it.next();
				UserInfo userInfo=new UserInfo();
				Department department=new Department();
				School school=new School();
				userInfo=m.getUserInfo();
				department=userInfo.getDepartment();
				school=department.getSchool();
				temp.setId(userInfo.getId());
				temp.setContent(m.getContent());
				temp.setTime(m.getTime());
				temp.setGrade(m.getGrade());
				temp.setDepartment(department.getName());
				temp.setSchool(school.getName());
				temp.setEmail(userInfo.getEmail());
				temp.setMobile(userInfo.getMobile());
				temp.setSex(userInfo.getSex());
				temp.setUserName(userInfo.getName());
				messageInfoList.add(temp);
			}
			return messageInfoList;
		} else
			return null;
	}

//	@SuppressWarnings("unchecked")
//	public List getAllMessages(Topic topic,int pageSize, int pageNow) {
//		List<MessageInfo> messageInfoList=new ArrayList();	
//		List list = messageDAO.queryByPage(topic,pageSize ,pageNow);
//		Iterator it=list.iterator();
//		if (list.size() > 0) {
//			CompareTime c = new CompareTime();
//			Collections.sort(list, c);
//			it=list.iterator();		
//			while(it.hasNext())
//			{
//				MessageInfo temp=new MessageInfo();
//				Message m=(Message)it.next();
//				UserInfo userInfo=new UserInfo();
//				Department department=new Department();
//				School school=new School();
//				userInfo=m.getUserInfo();
//				department=userInfo.getDepartment();
//				school=department.getSchool();
//				temp.setId(userInfo.getId());
//				temp.setContent(m.getContent());
//				temp.setTime(m.getTime());
//				temp.setGrade(m.getGrade());
//				temp.setDepartment(department.getName());
//				temp.setSchool(school.getName());
//				temp.setEmail(userInfo.getEmail());
//				temp.setMobile(userInfo.getMobile());
//				temp.setSex(userInfo.getSex());
//				temp.setUserName(userInfo.getName());
//				messageInfoList.add(temp);
//			}
//			return messageInfoList;
//		} else
//			return null;
//	}
	public List getAllMessages(Topic topic,int pageSize, int pageNow)
	{	
		List list = messageDAO.queryByPage(topic,pageSize ,pageNow);
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}
	public Message getMessageById(Integer id) {

		return messageDAO.findById(id);
	}

	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			messageDAO.merge(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getMessageByTopic(Topic topic){
		return messageDAO.findByTopicByOrder(topic);
	}
	
	/**
	 * 根据用户查找主题（grade为1的message）
	 * @param userInfo
	 * @return
	 */
	public List getMessageByUserInfo(UserInfo userInfo){
		return messageDAO.findTopicByUserInfo(userInfo);
	}
	
	public List getReplyMessageByUserInfo(UserInfo userInfo){
		return messageDAO.findReplyMessageByUserInfo(userInfo);
	}
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

}
