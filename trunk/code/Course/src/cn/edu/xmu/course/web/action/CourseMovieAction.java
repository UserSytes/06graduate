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
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	private ICourseMovieService courseMovieService;

	public String getCourseMovieListByCourse() {
		System.out.println(super.getCourse());
		courseMovieList = courseMovieService.getAllCourseMovies(super.getCourse());
		return SUCCESS;
	}
	public String getCourseMovieListByCourse2() {
		System.out.println(super.getCourse());
		courseMovieList = courseMovieService.getAllCourseMovies(super.getCourse());
		if(getCourseMovieList()==null)
			{
			addActionError("暂无教学视频！");
			return ERROR;
			}
		else
			return "movies";
	}
	public String addCourseMovie() {
		String fileLink = super.getTeacher().getUserInfo().getName() + "/"
		+ new Date().getTime()+"_"+super.getCourse().getName() + "_" + uploadFileName;
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

	public String getCourseMovieById(){
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (getCourseMovie()==null)
			return ERROR;
		else {
			return SUCCESS;
		}
	}
	public String getCourseMovieById2(){
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (getCourseMovie()==null)
		{
			addActionError("视频文件载入失败！");
			return ERROR;
		}
		else {
			return "movie";
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

	public void setCourseMovieService(ICourseMovieService courseMovieService) {
		this.courseMovieService = courseMovieService;
	}

	public ICourseMovieService getCourseMovieService() {
		return courseMovieService;
	}
	
	

}
