package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * School entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set administrators = new HashSet(0);
	private Set departments = new HashSet(0);

	// Constructors

	/** default constructor */
	public School() {
	}

	/** minimal constructor */
	public School(String name) {
		this.name = name;
	}

	/** full constructor */
	public School(String name, Set administrators, Set departments) {
		this.name = name;
		this.administrators = administrators;
		this.departments = departments;
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

	public Set getAdministrators() {
		return this.administrators;
	}

	public void setAdministrators(Set administrators) {
		this.administrators = administrators;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}