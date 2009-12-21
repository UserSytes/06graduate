package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TeacherCourse entity. @author MyEclipse Persistence Tools
 */

public class TeacherCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Course course;
	private Integer status;
	private String remark;
	private String level;
	private Set courseMovies = new HashSet(0);
	private Set applicationForms = new HashSet(0);
	private Set examinations = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set books = new HashSet(0);
	private Set chapters = new HashSet(0);
	private Set books_1 = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set applicationForms_1 = new HashSet(0);
	private Set courseMovies_1 = new HashSet(0);
	private Set chapters_1 = new HashSet(0);
	private Set topics_1 = new HashSet(0);
	private Set achievements_1 = new HashSet(0);
	private Set examinations_1 = new HashSet(0);

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
			String remark, String level, Set courseMovies,
			Set applicationForms, Set examinations, Set topics, Set books,
			Set chapters, Set books_1, Set achievements,
			Set applicationForms_1, Set courseMovies_1, Set chapters_1,
			Set topics_1, Set achievements_1, Set examinations_1) {
		this.teacher = teacher;
		this.course = course;
		this.status = status;
		this.remark = remark;
		this.level = level;
		this.courseMovies = courseMovies;
		this.applicationForms = applicationForms;
		this.examinations = examinations;
		this.topics = topics;
		this.books = books;
		this.chapters = chapters;
		this.books_1 = books_1;
		this.achievements = achievements;
		this.applicationForms_1 = applicationForms_1;
		this.courseMovies_1 = courseMovies_1;
		this.chapters_1 = chapters_1;
		this.topics_1 = topics_1;
		this.achievements_1 = achievements_1;
		this.examinations_1 = examinations_1;
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

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

	public Set getChapters() {
		return this.chapters;
	}

	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}

	public Set getBooks_1() {
		return this.books_1;
	}

	public void setBooks_1(Set books_1) {
		this.books_1 = books_1;
	}

	public Set getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set achievements) {
		this.achievements = achievements;
	}

	public Set getApplicationForms_1() {
		return this.applicationForms_1;
	}

	public void setApplicationForms_1(Set applicationForms_1) {
		this.applicationForms_1 = applicationForms_1;
	}

	public Set getCourseMovies_1() {
		return this.courseMovies_1;
	}

	public void setCourseMovies_1(Set courseMovies_1) {
		this.courseMovies_1 = courseMovies_1;
	}

	public Set getChapters_1() {
		return this.chapters_1;
	}

	public void setChapters_1(Set chapters_1) {
		this.chapters_1 = chapters_1;
	}

	public Set getTopics_1() {
		return this.topics_1;
	}

	public void setTopics_1(Set topics_1) {
		this.topics_1 = topics_1;
	}

	public Set getAchievements_1() {
		return this.achievements_1;
	}

	public void setAchievements_1(Set achievements_1) {
		this.achievements_1 = achievements_1;
	}

	public Set getExaminations_1() {
		return this.examinations_1;
	}

	public void setExaminations_1(Set examinations_1) {
		this.examinations_1 = examinations_1;
	}

}