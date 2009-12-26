package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private Department department;
	private Teacher teacher;
	private String name;
	private String remark;
	private Integer status; //是否审核通过，0：未审核，1：审核通过，2审核未通过
	private String level;
	private Set courseMovies = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set books = new HashSet(0);
	private Set teacherTeams = new HashSet(0);
	private Set applicationForms = new HashSet(0);
	private Set examinations = new HashSet(0);
	private Set courseInfos = new HashSet(0);
	private Set chapters = new HashSet(0);
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
	public Course(Department department, Teacher teacher, String name,
			String remark, Integer status, String level, Set courseMovies,
			Set collections, Set topics, Set achievements, Set books,
			Set teacherTeams, Set applicationForms, Set examinations,
			Set courseInfos, Set chapters, Set studentCourses) {
		this.department = department;
		this.teacher = teacher;
		this.name = name;
		this.remark = remark;
		this.status = status;
		this.level = level;
		this.courseMovies = courseMovies;
		this.collections = collections;
		this.topics = topics;
		this.achievements = achievements;
		this.books = books;
		this.teacherTeams = teacherTeams;
		this.applicationForms = applicationForms;
		this.examinations = examinations;
		this.courseInfos = courseInfos;
		this.chapters = chapters;
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

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Set getCourseMovies() {
		return this.courseMovies;
	}

	public void setCourseMovies(Set courseMovies) {
		this.courseMovies = courseMovies;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

	public Set getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set achievements) {
		this.achievements = achievements;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	public Set getTeacherTeams() {
		return this.teacherTeams;
	}

	public void setTeacherTeams(Set teacherTeams) {
		this.teacherTeams = teacherTeams;
	}

	public Set getApplicationForms() {
		return this.applicationForms;
	}

	public void setApplicationForms(Set applicationForms) {
		this.applicationForms = applicationForms;
	}

	public Set getExaminations() {
		return this.examinations;
	}

	public void setExaminations(Set examinations) {
		this.examinations = examinations;
	}

	public Set getCourseInfos() {
		return this.courseInfos;
	}

	public void setCourseInfos(Set courseInfos) {
		this.courseInfos = courseInfos;
	}

	public Set getChapters() {
		return this.chapters;
	}

	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}

	public Set getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(Set studentCourses) {
		this.studentCourses = studentCourses;
	}

}