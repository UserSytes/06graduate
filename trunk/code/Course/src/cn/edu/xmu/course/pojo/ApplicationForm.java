package cn.edu.xmu.course.pojo;

import java.util.Date;

/**
 * ApplicationForm entity. @author MyEclipse Persistence Tools
 */

public class ApplicationForm implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String unit;
	private String school;
	private String name;
	private String level;
	private String sort;
	private String firstSubject;
	private String secondSubjet;
	private String responser;
	private Date time;
	private String fileLink;
	private String filename;

	// Constructors

	/** default constructor */
	public ApplicationForm() {
	}

	/** minimal constructor */
	public ApplicationForm(String unit, String school, String name) {
		this.unit = unit;
		this.school = school;
		this.name = name;
	}

	/** full constructor */
	public ApplicationForm(Course course, String unit, String school,
			String name, String level, String sort, String firstSubject,
			String secondSubjet, String responser, Date time, String fileLink,
			String filename) {
		this.course = course;
		this.unit = unit;
		this.school = school;
		this.name = name;
		this.level = level;
		this.sort = sort;
		this.firstSubject = firstSubject;
		this.secondSubjet = secondSubjet;
		this.responser = responser;
		this.time = time;
		this.fileLink = fileLink;
		this.filename = filename;
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

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getFirstSubject() {
		return this.firstSubject;
	}

	public void setFirstSubject(String firstSubject) {
		this.firstSubject = firstSubject;
	}

	public String getSecondSubjet() {
		return this.secondSubjet;
	}

	public void setSecondSubjet(String secondSubjet) {
		this.secondSubjet = secondSubjet;
	}

	public String getResponser() {
		return this.responser;
	}

	public void setResponser(String responser) {
		this.responser = responser;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}