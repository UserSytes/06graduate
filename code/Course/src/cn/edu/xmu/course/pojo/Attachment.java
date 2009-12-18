package cn.edu.xmu.course.pojo;

/**
 * Attachment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Attachment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Achievement achievement;
	private String title;
	private String filename;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** minimal constructor */
	public Attachment(String title, String filename) {
		this.title = title;
		this.filename = filename;
	}

	/** full constructor */
	public Attachment(Achievement achievement, String title, String filename,
			String fileLink) {
		this.achievement = achievement;
		this.title = title;
		this.filename = filename;
		this.fileLink = fileLink;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Achievement getAchievement() {
		return this.achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileLink() {
		return this.fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

}