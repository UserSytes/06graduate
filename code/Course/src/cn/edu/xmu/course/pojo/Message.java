package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * Message entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfo;
	private Topic topic;
	private Date time;
	private String content;
	private Integer grade;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Date time, String content) {
		this.time = time;
		this.content = content;
	}

	/** full constructor */
	public Message(UserInfo userInfo, Topic topic, Date time, String content,
			Integer grade) {
		this.userInfo = userInfo;
		this.topic = topic;
		this.time = time;
		this.content = content;
		this.grade = grade;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}