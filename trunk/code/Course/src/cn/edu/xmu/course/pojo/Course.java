package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private String name;
	private String remark;
	private Set collections = new HashSet(0);
	private Set teacherCourses = new HashSet(0);
	private Set teacherTeams = new HashSet(0);
	private Set courseInfos = new HashSet(0);
	private Set studentCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String name) {
		this.name = name;
	}

	/** full constructor */
	public Course(Department department, String name, String remark,
			Set collections, Set teacherCourses, Set teacherTeams,
			Set courseInfos, Set studentCourses) {
		this.department = department;
		this.name = name;
		this.remark = remark;
		this.collections = collections;
		this.teacherCourses = teacherCourses;
		this.teacherTeams = teacherTeams;
		this.courseInfos = courseInfos;
		this.studentCourses = studentCourses;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getTeacherCourses() {
		return this.teacherCourses;
	}

	public void setTeacherCourses(Set teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	public Set getTeacherTeams() {
		return this.teacherTeams;
	}

	public void setTeacherTeams(Set teacherTeams) {
		this.teacherTeams = teacherTeams;
	}

	public Set getCourseInfos() {
		return this.courseInfos;
	}

	public void setCourseInfos(Set courseInfos) {
		this.courseInfos = courseInfos;
	}

	public Set getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(Set studentCourses) {
		this.studentCourses = studentCourses;
	}

}