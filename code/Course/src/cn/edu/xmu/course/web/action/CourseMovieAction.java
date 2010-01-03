package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.pojo.Courseware;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IChapterService;
import cn.edu.xmu.course.service.ICourseMovieService;
import cn.edu.xmu.course.service.ICoursewareService;

public class CourseMovieAction extends BaseAction {

	private List<CourseMovie> courseMovieList;
	private CourseMovie courseMovie;
	private Integer courseMovieId;
	
	private Course course;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private ICourseMovieService courseMovieService;

	public String getCourseMovieListByCourse() {
		course = super.getCourse();
		courseMovieList = courseMovieService.getAllCourseMovies(course);
		return SUCCESS;
	}

	public String addCourseMovie() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		courseMovie.setFilename(uploadFileName);
		courseMovie.setFileLink(fileLink);
		if (courseMovieService.addCourseMovie(courseMovie, super.getCourse(), upload))
			return SUCCESS;
		else {
			addActionError("添加教学录像失败，请重新添加！");
			return ERROR;
		}
	}

	public String goEditCourseMovie() {
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);		
		return SUCCESS;
	}

	public String updateCourseMovie() {
		String fileLink = super.getPreFileNameByTeacher() + uploadFileName;
		courseMovie.setFilename(uploadFileName);
		courseMovie.setFileLink(fileLink);
		if (courseMovieService.updateCourseMovie(courseMovie,upload))
			return SUCCESS;
		else {
			addActionError("更新教学录像失败，请重新操作！");
			return ERROR;
		}
	}

	public String deleteCourseMovie() {
		CourseMovie delCourseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (courseMovieService.deleteCourseMovie(delCourseMovie))
			return SUCCESS;
		else {
			addActionError("删除教学录像失败，请重新操作！");
			return ERROR;
		}
	}


	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<CourseMovie> getCourseMovieList() {
		return courseMovieList;
	}

	public void setCourseMovieList(List<CourseMovie> courseMovieList) {
		this.courseMovieList = courseMovieList;
	}

	public CourseMovie getCourseMovie() {
		return courseMovie;
	}

	public void setCourseMovie(CourseMovie courseMovie) {
		this.courseMovie = courseMovie;
	}

	public Integer getCourseMovieId() {
		return courseMovieId;
	}

	public void setCourseMovieId(Integer courseMovieId) {
		this.courseMovieId = courseMovieId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setCourseMovieService(ICourseMovieService courseMovieService) {
		this.courseMovieService = courseMovieService;
	}

	public ICourseMovieService getCourseMovieService() {
		return courseMovieService;
	}
	
	

}
