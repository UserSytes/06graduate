package cn.edu.xmu.course.pojo;

/**
 * StudentCourse entity. @author MyEclipse Persistence Tools
 */

public class StudentCourse implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private Course course;
	private Integer status;

	// Constructors

	/** default constructor */
	public StudentCourse() {
	}

	/** minimal constructor */
	public StudentCourse(Student student, Integer status) {
		this.student = student;
		this.status = status;
	}

	/** full constructor */
	public StudentCourse(Student student, Course course, Integer status) {
		this.student = student;
		this.course = course;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

}