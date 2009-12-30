package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter entity. @author MyEclipse Persistence Tools
 */

public class Chapter implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String number;
	private String name;
	private String remark;
	private Set exercises = new HashSet(0);
	private Set experiments = new HashSet(0);
	private Set coursewares = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chapter() {
	}

	/** minimal constructor */
	public Chapter(String number, String name) {
		this.number = number;
		this.name = name;
	}

	/** full constructor */
	public Chapter(Course course, String number, String name, String remark,
			Set exercises, Set experiments, Set coursewares) {
		this.course = course;
		this.number = number;
		this.name = name;
		this.remark = remark;
		this.exercises = exercises;
		this.experiments = experiments;
		this.coursewares = coursewares;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public Set getExercises() {
		return this.exercises;
	}

	public void setExercises(Set exercises) {
		this.exercises = exercises;
	}

	public Set getExperiments() {
		return this.experiments;
	}

	public void setExperiments(Set experiments) {
		this.experiments = experiments;
	}

	public Set getCoursewares() {
		return this.coursewares;
	}

	public void setCoursewares(Set coursewares) {
		this.coursewares = coursewares;
	}

}