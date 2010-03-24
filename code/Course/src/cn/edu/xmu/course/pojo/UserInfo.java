package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String name;
	private String sex;
	private String email;
	private String photo;
	private Long mobile;
	private Set mailsForReceiverId = new HashSet(0);
	private Set mailsForSenderId = new HashSet(0);
	private Set messages = new HashSet(0);
	private Set teachers = new HashSet(0);
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(Department department, String name, String sex,
			String email, Long mobile,String photo, Set mailsForReceiverId,
			Set mailsForSenderId, Set messages, Set teachers, Set students) {
		this.department = department;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.mobile = mobile;
		this.setPhoto(photo);
		this.mailsForReceiverId = mailsForReceiverId;
		this.mailsForSenderId = mailsForSenderId;
		this.messages = messages;
		this.teachers = teachers;
		this.students = students;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return this.mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Set getMailsForReceiverId() {
		return this.mailsForReceiverId;
	}

	public void setMailsForReceiverId(Set mailsForReceiverId) {
		this.mailsForReceiverId = mailsForReceiverId;
	}

	public Set getMailsForSenderId() {
		return this.mailsForSenderId;
	}

	public void setMailsForSenderId(Set mailsForSenderId) {
		this.mailsForSenderId = mailsForSenderId;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhoto() {
		return photo;
	}

}