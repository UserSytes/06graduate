package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.service.ICourseMovieService;

/**
 * 负责教学录像的类
 * 
 * @author 何申密
 * @author 许子彦
 * 
 */
public class CourseMovieAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030627275684855548L;
	private List<CourseMovie> courseMovieList; // 教学录像列表
	private CourseMovie courseMovie; // 教学录像
	private Integer courseMovieId; // 教学录像ID

	private File upload; // 录像
	private String uploadContentType; // 文件类型
	private String uploadFileName; // 文件名称

	private ICourseMovieService courseMovieService; // 负责教学录像的接口

	/**
	 * 根据课程查找教学录像
	 * 
	 * @return
	 */
	public String getCourseMovieListByCourse() {
		System.out.println(super.getCourse());
		courseMovieList = courseMovieService.getAllCourseMovies(super
				.getCourse());
		return SUCCESS;
	}

	/**
	 * 添加教学录像(自己上传录像）
	 * 
	 * @return
	 */
	public String addCourseMovie() {
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "movie/" + new Date().getTime()
				+ uploadFileName.substring(pos);
		courseMovie.setFilename(uploadFileName);
		courseMovie.setFileLink(fileLink);
		if (courseMovieService.addCourseMovie(courseMovie, super.getCourse(),
				upload))
			return SUCCESS;
		else {
			addActionError("添加教学录像失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 添加教学录像（使用已有链接）
	 * 
	 * @return
	 */
	public String addCourseMovieSrc() {
		if (courseMovieService.addCourseMovie(courseMovie, super.getCourse(),
				null))
			return SUCCESS;
		else {
			addActionError("添加教学录像失败，请重新添加！");
			return ERROR;
		}
	}

	/**
	 * 跳转到编辑教学录像
	 * 
	 * @return
	 */
	public String goEditCourseMovie() {
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (courseMovie.getSrc().equals(""))
			return "upload";
		else
			return "src";
	}

	/**
	 * 更新教学录像
	 * 
	 * @return
	 */
	public String updateCourseMovie() {
		int pos = uploadFileName.lastIndexOf(".");
		String fileLink = "movie/" + new Date().getTime()
				+ uploadFileName.substring(pos);
		courseMovie.setFilename(uploadFileName);
		courseMovie.setFileLink(fileLink);
		if (courseMovieService.updateCourseMovie(courseMovie, upload))
			return SUCCESS;
		else {
			addActionError("更新教学录像失败，请重新操作！");
			return ERROR;
		}
	}
	
	/**
	 * 更新教学录像（使用已有链接）
	 * 
	 * @return
	 */
	public String updateCourseMovieSrc() {
		if (courseMovieService.updateCourseMovie(courseMovie, null))
			return SUCCESS;
		else {
			addActionError("更新教学录像失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 删除教学录像
	 * 
	 * @return
	 */
	public String deleteCourseMovie() {
		CourseMovie delCourseMovie = courseMovieService
				.getCourseMovieById(courseMovieId);
		if (courseMovieService.deleteCourseMovie(delCourseMovie))
			return SUCCESS;
		else {
			addActionError("删除教学录像失败，请重新操作！");
			return ERROR;
		}
	}

	/**
	 * 根据ID查找教学录像
	 * 
	 * @return
	 */
	public String getCourseMovieById() {
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (getCourseMovie() == null) {
			addActionError("视频文件载入失败！");
			return ERROR;
		} else {
			return SUCCESS;
		}
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

	public ICourseMovieService getCourseMovieService() {
		return courseMovieService;
	}

	public void setCourseMovieService(ICourseMovieService courseMovieService) {
		this.courseMovieService = courseMovieService;
	}
	
	
}
