package cn.edu.xmu.course.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String name;
	private Date time;
	private String authorName;
	private String lastAnswer;
	private Integer countPerson;
	private Date lastUpdate;
	private Integer countReply;
	private Set messages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String name, Date time, String authorName) {
		this.name = name;
		this.time = time;
		this.authorName = authorName;
	}

	/** full constructor */
	public Topic(Course course, String name, Date time, String authorName,
			String lastAnswer, Integer countPerson, Date lastUpdate,
			Integer countReply, Set messages) {
		this.course = course;
		this.name = name;
		this.time = time;
		this.authorName = authorName;
		this.lastAnswer = lastAnswer;
		this.countPerson = countPerson;
		this.lastUpdate = lastUpdate;
		this.countReply = countReply;
		this.messages = messages;
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

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLastAnswer() {
		return this.lastAnswer;
	}

	public void setLastAnswer(String lastAnswer) {
		this.lastAnswer = lastAnswer;
	}

	public Integer getCountPerson() {
		return this.countPerson;
	}

	public void setCountPerson(Integer countPerson) {
		this.countPerson = countPerson;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getCountReply() {
		return this.countReply;
	}

	public void setCountReply(Integer countReply) {
		this.countReply = countReply;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

}