package cn.edu.xmu.course.pojo;

/**
 * SuperAdmin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SuperAdmin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Long account;
	private String password;
	private String email;
	private Long mobile;

	// Constructors

	/** default constructor */
	public SuperAdmin() {
	}

	/** minimal constructor */
	public SuperAdmin(String name, Long account, String password) {
		this.name = name;
		this.account = account;
		this.password = password;
	}

	/** full constructor */
	public SuperAdmin(String name, Long account, String password, String email,
			Long mobile) {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccount() {
		return this.account;
	}

	public void setAccount(Long account) {
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