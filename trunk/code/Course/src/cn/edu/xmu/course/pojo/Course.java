package cn.edu.xmu.course.pojo;

import java.util.Date;
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
	private Integer status;
	private String level;
	private String refuseReason;
	private Integer count;
	private Integer visible;
	private String style;
	private String header;
	private Date time;
	private Set courseMovies = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set evaluations = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set books = new HashSet(0);
	private Set applicationForms = new HashSet(0);
	private Set examinations = new HashSet(0);
	private Set chapters = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set teacherTeams = new HashSet(0);
	private Set courseInfos = new HashSet(0);
	private Set studentCourses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String name, Integer status, Integer visible) {
		this.name = name;
		this.status = status;
		this.visible = visible;
	}

	/** full constructor */
	public Course(Department department, Teacher teacher, String name,
			String remark, Integer status, String level, String refuseReason,
			Integer count, Integer visible, String style,Date time, Set courseMovies,
			Set collections, Set evaluations, Set topics, Set books,
			Set applicationForms, Set examinations, Set chapters,
			Set achievements, Set notices, Set teacherTeams, Set courseInfos,
			Set studentCourses) {
		this.department = department;
		this.teacher = teacher;
		this.name = name;
		this.remark = remark;
		this.status = status;
		this.level = level;
		this.refuseReason = refuseReason;
		this.count = count;
		this.visible = visible;
		this.style = style;
		this.setTime(time);
		this.courseMovies = courseMovies;
		this.collections = collections;
		this.evaluations = evaluations;
		this.topics = topics;
		this.books = books;
		this.applicationForms = applicationForms;
		this.examinations = examinations;
		this.chapters = chapters;
		this.achievements = achievements;
		this.notices = notices;
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

	public String getRefuseReason() {
		return this.refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getVisible() {
		return this.visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public Set getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(Set evaluations) {
		this.evaluations = evaluations;
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

	public Set getChapters() {
		return this.chapters;
	}

	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}

	public Set getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set achievements) {
		this.achievements = achievements;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
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

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeader() {
		return header;
	}

}