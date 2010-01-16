package cn.edu.xmu.course.pojo;

/**
 * Evaluation entity. @author MyEclipse Persistence Tools
 */

public class Evaluation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String username;
	private String password;
	private Integer status;
	private String name;
	private String company;
	private String position;
	private Long phone;
	private String email;
	private String content;
	private Float score;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** full constructor */
	public Evaluation(Course course, String username, String password,
			Integer status, String name, String company, String position,
			Long phone, String email, String content, Float score) {
		this.course = course;
		this.username = username;
		this.password = password;
		this.status = status;
		this.name = name;
		this.company = company;
		this.position = position;
		this.phone = phone;
		this.email = email;
		this.content = content;
		this.score = score;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}