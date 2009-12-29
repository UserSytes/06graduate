package cn.edu.xmu.course.pojo;

/**
 * Attachment entity. @author MyEclipse Persistence Tools
 */

public class Attachment implements java.io.Serializable {

	// Fields

	private Integer id;
	private News news;
	private String filename;
	private String fileLink;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** full constructor */
	public Attachment(News news, String filename, String fileLink) {
		this.news = news;
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

	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
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