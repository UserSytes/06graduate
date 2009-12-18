package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserInfo userInfo;
	private String studentNo;
	private String password;
	private Integer grade;
	private Set collections = new HashSet(0);
	private Set studentCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentNo, String password) {
		this.studentNo = studentNo;
		this.password = password;
	}

	/** full constructor */
	public Student(UserInfo userInfo, String studentNo, String password,
			Integer grade, Set collections, Set studentCourses) {
		this.userInfo = userInfo;
		this.studentNo = studentNo;
		this.password = password;
		this.grade = grade;
		this.collections = collections;
		this.studentCourses = studentCourses;
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

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(Set studentCourses) {
		this.studentCourses = studentCourses;
	}

}