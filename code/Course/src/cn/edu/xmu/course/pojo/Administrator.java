package cn.edu.xmu.course.pojo;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private School school;
	private String name;
	private String account;
	private String password;
	private String email;
	private Long mobile;

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** minimal constructor */
	public Administrator(School school, String name, String account,
			String password) {
		this.school = school;
		this.name = name;
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public Administrator(School school, String name, String account,
			String password, String email, Long mobile) {
		this.school = school;
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public School getSchool() {
		return this.school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return this.mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

}