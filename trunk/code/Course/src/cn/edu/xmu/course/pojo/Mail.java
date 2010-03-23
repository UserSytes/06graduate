package cn.edu.xmu.course.pojo;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */

public class Mail implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo sender;
	private UserInfo receiver;
	private String title;
	private String content;
	private Integer status;
	private Integer sort;

	// Constructors

	/** default constructor */
	public Mail() {
	}

	/** full constructor */
	public Mail(UserInfo userInfoBySenderId, UserInfo userInfoByReceiverId,
			String title, String content, Integer status, Integer sort) {
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.content = content;
		this.status = status;
		this.sort = sort;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setReceiver(UserInfo receiver) {
		this.receiver = receiver;
	}

	public UserInfo getReceiver() {
		return receiver;
	}

	public void setSender(UserInfo sender) {
		this.sender = sender;
	}

	public UserInfo getSender() {
		return sender;
	}

}