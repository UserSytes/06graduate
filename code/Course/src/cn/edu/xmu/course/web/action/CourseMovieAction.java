package cn.edu.xmu.course.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.CourseMovie;
import cn.edu.xmu.course.service.ICourseMovieService;

/**
 * �����ѧ¼�����
 * 
 * @author ������
 * @author ������
 * 
 */
public class CourseMovieAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030627275684855548L;
	private List<CourseMovie> courseMovieList; // ��ѧ¼���б�
	private CourseMovie courseMovie; // ��ѧ¼��
	private Integer courseMovieId; // ��ѧ¼��ID

	private File upload; // ¼��
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ�����

	private ICourseMovieService courseMovieService; // �����ѧ¼��Ľӿ�

	/**
	 * ���ݿγ̲��ҽ�ѧ¼��
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
	 * ��ӽ�ѧ¼��(�Լ��ϴ�¼��
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
			addActionError("��ӽ�ѧ¼��ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ӽ�ѧ¼��ʹ���������ӣ�
	 * 
	 * @return
	 */
	public String addCourseMovieSrc() {
		if (courseMovieService.addCourseMovie(courseMovie, super.getCourse(),
				null))
			return SUCCESS;
		else {
			addActionError("��ӽ�ѧ¼��ʧ�ܣ���������ӣ�");
			return ERROR;
		}
	}

	/**
	 * ��ת���༭��ѧ¼��
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
	 * ���½�ѧ¼��
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
			addActionError("���½�ѧ¼��ʧ�ܣ������²�����");
			return ERROR;
		}
	}
	
	/**
	 * ���½�ѧ¼��ʹ���������ӣ�
	 * 
	 * @return
	 */
	public String updateCourseMovieSrc() {
		if (courseMovieService.updateCourseMovie(courseMovie, null))
			return SUCCESS;
		else {
			addActionError("���½�ѧ¼��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ɾ����ѧ¼��
	 * 
	 * @return
	 */
	public String deleteCourseMovie() {
		CourseMovie delCourseMovie = courseMovieService
				.getCourseMovieById(courseMovieId);
		if (courseMovieService.deleteCourseMovie(delCourseMovie))
			return SUCCESS;
		else {
			addActionError("ɾ����ѧ¼��ʧ�ܣ������²�����");
			return ERROR;
		}
	}

	/**
	 * ����ID���ҽ�ѧ¼��
	 * 
	 * @return
	 */
	public String getCourseMovieById() {
		courseMovie = courseMovieService.getCourseMovieById(courseMovieId);
		if (getCourseMovie() == null) {
			addActionError("��Ƶ�ļ�����ʧ�ܣ�");
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
