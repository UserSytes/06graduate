package cn.edu.xmu.course.pojo;

/**
 * TeacherTeam entity. @author MyEclipse Persistence Tools
 */

public class TeacherTeam implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String name;
	private String position;
	private String link;
	private String remark;

	// Constructors

	/** default constructor */
	public TeacherTeam() {
	}

	/** minimal constructor */
	public TeacherTeam(String name, String position) {
		this.name = name;
		this.position = position;
	}

	/** full constructor */
	public TeacherTeam(Course course, String name, String position,
			String link, String remark) {
		this.course = course;
		this.name = name;
		this.position = position;
		this.link = link;
		this.remark = remark;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}