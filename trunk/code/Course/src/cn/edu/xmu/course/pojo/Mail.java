package cn.edu.xmu.course.pojo;

/**
 * Mail entity. @author MyEclipse Persistence Tools
 */

public class Mail implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfoBySenderId;
	private UserInfo userInfoByReceiverId;
	private String title;
	private String content;
	private Integer status;

	// Constructors

	/** default constructor */
	public Mail() {
	}

	/** full constructor */
	public Mail(UserInfo userInfoBySenderId, UserInfo userInfoByReceiverId,
			String title, String content, Integer status) {
		this.userInfoBySenderId = userInfoBySenderId;
		this.userInfoByReceiverId = userInfoByReceiverId;
		this.title = title;
		this.content = content;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserInfo getUserInfoBySenderId() {
		return this.userInfoBySenderId;
	}

	public void setUserInfoBySenderId(UserInfo userInfoBySenderId) {
		this.userInfoBySenderId = userInfoBySenderId;
	}

	public UserInfo getUserInfoByReceiverId() {
		return this.userInfoByReceiverId;
	}

	public void setUserInfoByReceiverId(UserInfo userInfoByReceiverId) {
		this.userInfoByReceiverId = userInfoByReceiverId;
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

}