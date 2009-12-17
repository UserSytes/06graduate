package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String name;
	private Set userInfos = new HashSet(0);
	private Set courses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(School school, String name) {
		this.school = school;
		this.name = name;
	}

	/** full constructor */
	public Department(School school, String name, Set userInfos, Set courses) {
		this.school = school;
		this.name = name;
		this.userInfos = userInfos;
		this.courses = courses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set userInfos) {
		this.userInfos = userInfos;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}