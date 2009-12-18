package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TeacherCourse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TeacherCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Course course;
	private Integer status;
	private String remark;
	private Set courseMovies = new HashSet(0);
	private Set examinations = new HashSet(0);
	private Set chapters = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set books = new HashSet(0);
	private Set applicationForms = new HashSet(0);

	// Constructors

	/** default constructor */
	public TeacherCourse() {
	}

	/** minimal constructor */
	public TeacherCourse(Teacher teacher, Integer status) {
		this.teacher = teacher;
		this.status = status;
	}

	/** full constructor */
	public TeacherCourse(Teacher teacher, Course course, Integer status,
			String remark, Set courseMovies, Set examinations, Set chapters,
			Set topics, Set achievements, Set books, Set applicationForms) {
		this.teacher = teacher;
		this.course = course;
		this.status = status;
		this.remark = remark;
		this.courseMovies = courseMovies;
		this.examinations = examinations;
		this.chapters = chapters;
		this.topics = topics;
		this.achievements = achievements;
		this.books = books;
		this.applicationForms = applicationForms;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getCourseMovies() {
		return this.courseMovies;
	}

	public void setCourseMovies(Set courseMovies) {
		this.courseMovies = courseMovies;
	}

	public Set getExaminations() {
		return this.examinations;
	}

	public void setExaminations(Set examinations) {
		this.examinations = examinations;
	}

	public Set getChapters() {
		return this.chapters;
	}

	public void setChapters(Set chapters) {
		this.chapters = chapters;
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

	public Set getApplicationForms() {
		return this.applicationForms;
	}

	public void setApplicationForms(Set applicationForms) {
		this.applicationForms = applicationForms;
	}

}