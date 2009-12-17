package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfo;
	private Long teacherNo;
	private String password;
	private Set teacherCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Long teacherNo, String password) {
		this.teacherNo = teacherNo;
		this.password = password;
	}

	/** full constructor */
	public Teacher(UserInfo userInfo, Long teacherNo, String password,
			Set teacherCourses) {
		this.userInfo = userInfo;
		this.teacherNo = teacherNo;
		this.password = password;
		this.teacherCourses = teacherCourses;
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

	public Long getTeacherNo() {
		return this.teacherNo;
	}

	public void setTeacherNo(Long teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getTeacherCourses() {
		return this.teacherCourses;
	}

	public void setTeacherCourses(Set teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

}