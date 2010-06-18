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
	private Popedom popedom;
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
	private String number;
	private Set teacherTeams = new HashSet(0);
	private Set topics = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set applicationForms = new HashSet(0);
	private Set courseInfos = new HashSet(0);
	private Set examinations = new HashSet(0);
	private Set studentCourses = new HashSet(0);
	private Set achievements = new HashSet(0);
	private Set books = new HashSet(0);
	private Set evaluations = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set chapters = new HashSet(0);
	private Set courseMovies = new HashSet(0);

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
	public Course(Popedom popedom, Department department, Teacher teacher,
			String name, String remark, Integer status, String level,
			String refuseReason, Integer count, Integer visible, String style,
			String header, Date time, String number, Set teacherTeams,
			Set topics, Set notices, Set applicationForms, Set courseInfos,
			Set examinations, Set studentCourses, Set achievements, Set books,
			Set evaluations, Set collections, Set chapters, Set courseMovies) {
		this.popedom = popedom;
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
		this.header = header;
		this.time = time;
		this.number = number;
		this.teacherTeams = teacherTeams;
		this.topics = topics;
		this.notices = notices;
		this.applicationForms = applicationForms;
		this.courseInfos = courseInfos;
		this.examinations = examinations;
		this.studentCourses = studentCourses;
		this.achievements = achievements;
		this.books = books;
		this.evaluations = evaluations;
		this.collections = collections;
		this.chapters = chapters;
		this.courseMovies = courseMovies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Popedom getPopedom() {
		return this.popedom;
	}

	public void setPopedom(Popedom popedom) {
		this.popedom = popedom;
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

	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set getTeacherTeams() {
		return this.teacherTeams;
	}

	public void setTeacherTeams(Set teacherTeams) {
		this.teacherTeams = teacherTeams;
	}

	public Set getTopics() {
		return this.topics;
	}

	public void setTopics(Set topics) {
		this.topics = topics;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

	public Set getApplicationForms() {
		return this.applicationForms;
	}

	public void setApplicationForms(Set applicationForms) {
		this.applicationForms = applicationForms;
	}

	public Set getCourseInfos() {
		return this.courseInfos;
	}

	public void setCourseInfos(Set courseInfos) {
		this.courseInfos = courseInfos;
	}

	public Set getExaminations() {
		return this.examinations;
	}

	public void setExaminations(Set examinations) {
		this.examinations = examinations;
	}

	public Set getStudentCourses() {
		return this.studentCourses;
	}

	public void setStudentCourses(Set studentCourses) {
		this.studentCourses = studentCourses;
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

	public Set getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(Set evaluations) {
		this.evaluations = evaluations;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getChapters() {
		return this.chapters;
	}

	public void setChapters(Set chapters) {
		this.chapters = chapters;
	}

	public Set getCourseMovies() {
		return this.courseMovies;
	}

	public void setCourseMovies(Set courseMovies) {
		this.courseMovies = courseMovies;
	}

}