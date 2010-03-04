package cn.edu.xmu.course.web.action;


import java.sql.Date;
import java.util.List;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.INewsService;
import cn.edu.xmu.course.service.impl.LoginService;
import cn.edu.xmu.course.service.impl.NewsService;

public class HomePageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<News> newsList;
	private List<News> tempList;
	private List<News> getTempList() {
		return tempList;
	}

	private void setTempList(List<News> tempList) {
		this.tempList = tempList;
	}

	private List<Course> courseList;
	private IApplicationFormService applicationFormService;
	private ICourseService courseService;
	private INewsService newsService;
	private int newsId;
	private News news;
	private int flag;
	private String userName,password;
	private ILoginService loginService;
	private int courseId;
	private String level="country";
	private List<String> times=null;
	private int country;
	private int province;
	private int school;
	
	private List<Course> achievementList;
	/**
	 * ���Ź���
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public String homepageDisplay(){
    	newsList=newsService.findAllNews();
		for(int i=6;i<newsList.size();i++)
		{
			newsList.remove(i);
		}
		courseList = courseService.findCourseListByLevel("country");
    	country=courseList.size();
    	System.out.println("test_country: "+country);
    	courseList = courseService.findCourseListByLevel("province");
    	province=courseList.size();
    	System.out.println("test_province: "+province);
    	courseList = courseService.findCourseListByLevel("school");
    	school=courseList.size();
    	System.out.println("test_school: "+school);
		if (newsList == null) {
			return ERROR;
		} else
			return "news";
	}
    public String newsDisplay(){
    	newsList=newsService.findAllNews();
		if (newsList == null) {
			return ERROR;
		} else
			return "news";
	}
    public String enterNews(){
    	news=newsService.findNewsById(newsId);
		if (news == null) {
			return ERROR;
		} else
			return "newsdetail";
    }
    

    

	public String loginFromHomePage() {
		
		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName, getPassword());
			System.out.println(userName);
			if (null == teacher)
				return ERROR;
			else {
				System.out.println(teacher.getPassword());
				ActionSession.getSession().put(TEACHER, teacher);
				return "teacher";
			}
		} else {
			Student student = getLoginService().studentLogin(userName, getPassword());
			System.out.println(userName);
			if (null == student)
				return ERROR;
			else {
				System.out.println("test1: "+student.getPassword());
				ActionSession.getSession().put(STUDENT, student);
				return "student";
			}
		}
	}
    
    public String courseDisplay(){
    	courseList = courseService.findCourseListByLevel(level);
		
		System.out.println("test1: "+courseList.size());
		if (courseList == null) {
			return ERROR;
		} else
			return "courseList";
    }
    public String achievementDisplay(){
    	achievementList=courseService.findCourseListLevel(level);
    	System.out.println("test1: "+achievementList.size());
		if (achievementList == null) {
			return ERROR;
		} else
			return "achievementList";
    }
    
    
    public String forwardToSearch(){
			return "searchbyschool";
    }
    public String forwardToIndex(){
		return "index";
}
    public String forwardToContact(){
		return "contact";
}
    
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public INewsService getNewsService() {
		return newsService;
	}
	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public int getNewsId() {
		return newsId;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNews() {
		return news;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public IApplicationFormService getApplicationFormService() {
		return applicationFormService;
	}

	public void setApplicationFormService(
			IApplicationFormService applicationFormService) {
		this.applicationFormService = applicationFormService;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setAchievementList(List<Course> achievementList) {
		this.achievementList = achievementList;
	}

	public List<Course> getAchievementList() {
		return achievementList;
	}

	public List<String> getTimes() {
		return times;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getSchool() {
		return school;
	}

	public void setSchool(int school) {
		this.school = school;
	}



}
