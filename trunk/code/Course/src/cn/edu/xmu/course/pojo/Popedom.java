package cn.edu.xmu.course.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Popedom entity. @author MyEclipse Persistence Tools
 */

public class Popedom implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer outline;
	private Integer courseware;
	private Integer exercise;
	private Integer experiment;
	private Integer movie;
	private Integer examination;
	private Integer book;
	private Set courses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Popedom() {
	}

	/** full constructor */
	public Popedom(Integer outline, Integer courseware, Integer exercise,
			Integer experiment, Integer movie, Integer examination,
			Integer book, Set courses) {
		this.outline = outline;
		this.courseware = courseware;
		this.exercise = exercise;
		this.experiment = experiment;
		this.movie = movie;
		this.examination = examination;
		this.book = book;
		this.courses = courses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOutline() {
		return this.outline;
	}

	public void setOutline(Integer outline) {
		this.outline = outline;
	}

	public Integer getCourseware() {
		return this.courseware;
	}

	public void setCourseware(Integer courseware) {
		this.courseware = courseware;
	}

	public Integer getExercise() {
		return this.exercise;
	}

	public void setExercise(Integer exercise) {
		this.exercise = exercise;
	}

	public Integer getExperiment() {
		return this.experiment;
	}

	public void setExperiment(Integer experiment) {
		this.experiment = experiment;
	}

	public Integer getMovie() {
		return this.movie;
	}

	public void setMovie(Integer movie) {
		this.movie = movie;
	}

	public Integer getExamination() {
		return this.examination;
	}

	public void setExamination(Integer examination) {
		this.examination = examination;
	}

	public Integer getBook() {
		return this.book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

}