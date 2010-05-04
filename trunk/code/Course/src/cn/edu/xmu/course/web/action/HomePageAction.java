package cn.edu.xmu.course.web.action;


import java.sql.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Attachment;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.News;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.pojo.UserInfo;
import cn.edu.xmu.course.service.IApplicationFormService;
import cn.edu.xmu.course.service.ICourseService;
import cn.edu.xmu.course.service.ILoginService;
import cn.edu.xmu.course.service.INewsService;
import cn.edu.xmu.course.service.ISearchCourseService;
import cn.edu.xmu.course.service.impl.LoginService;
import cn.edu.xmu.course.service.impl.NewsService;

public class HomePageAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<News> newsList;
    private UserInfo userInfo;
	private List<Course> courseList;
	private IApplicationFormService applicationFormService;
	private ICourseService courseService;
	private INewsService newsService;
	private ISearchCourseService searchCourseService;
	
	private int newsId;
	private News news;
	private int flag;
	private String userName,password;
	private ILoginService loginService;
	private int courseId;
	private String level="country";
	private List<String> times=null;//没用的。。。应该要删除掉
	private int country;
	private int province;
	private int school;
	private String levelNow;
	
	private Student student;
	
	private List<Attachment> attachmentList;
	private List<Course> achievementList;
	private String ifAttachment;
	private String idLogin;
	private String afterLogin;
	private String user;
	/**
	 * 首页数据载入
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public String homepageDisplay(){
    	System.out.println("测试首页1："+super.getSession());
    	user = (String) super.getSession().get("user");
    	System.out.println("测试首页："+user);
    	if( user == null){
    		this.setIdLogin("block");
    		this.setAfterLogin("none");
    	}else{
    		this.setIdLogin("none");
    		this.setAfterLogin("block");
    	}
    	
    	newsList=newsService.findLastestTenNews();
		this.countCourseByLevel();
		courseList = searchCourseService.findCourseByDate(30);
    	if(courseList == null){
			addActionMessage("最近一个月未发布新课程！");
		}    	
		return SUCCESS;
	}

    
    /**
     * 计算级别课程数
     */
    public void countCourseByLevel(){
    	courseList = courseService.findCourseListLevel("country");
    	country=courseList.size();
    	courseList = courseService.findCourseListLevel("province");
    	province=courseList.size();
    	courseList = courseService.findCourseListLevel("school");
    	school=courseList.size();
    }
    
    /**
     * 查找所有课程
     * @return
     */
    public String newsDisplay(){
    	newsList=newsService.findAllNews();
		if (newsList == null) {
			addActionError("对不起，目前尚无任何新闻，请重新操作！");
			return ERROR;
		} else
			return "news";
	}
    
    /**
     * 查看选定课程
     * @return
     */
    public String enterNews(){
    	news=newsService.findNewsById(newsId);
		if (news == null) {
			addActionError("对不起，该新闻不存在，请重新操作！");
			return ERROR;
		} else{
			news.setCount( news.getCount() +1 );
			newsService.updateNewsWithoutAttachment(news);
			attachmentList = newsService.findAttachmentByNews(news);
			if(attachmentList.size()!=0){
				ifAttachment = "附件下载：";
			}else{
				ifAttachment = "";
			}
			return "newsdetail";
		}
    }
    

    /**
     * 首页登录
     * @return
     */
	public String loginFromHomePage() {
		
		if (getFlag() == 0) {
			Teacher teacher = getLoginService().teacherLogin(userName, getPassword());
			if (null == teacher){
				addActionError("帐号或者密码错误，请重新登录！");
				this.homepageDisplay();
				return ERROR;
			}
			else {
				userInfo = teacher.getUserInfo();
				super.getSession().put(TEACHER, teacher);
				super.getSession().put("user", teacher.getUserInfo().getName()+"老师");
				super.getSession().put(USERINFO, userInfo);
				return "teacher";
			}
		} else {
			student = getLoginService().studentLogin(userName, getPassword());
			if (null == student){
				addActionError("帐号或者密码错误，请重新登录！");
				this.homepageDisplay();
				return ERROR;
			}
			else {
				super.getSession().put(STUDENT, student);
				super.getSession().put("user", student.getUserInfo().getName()+"同学");
				userInfo = student.getUserInfo();
				super.getSession().put(USERINFO, userInfo);
				return "student";
			}
		}
	}
       
    /**
	 * 根据级别查找课程
	 * @return
	 */
    public String achievementDisplay(){
    	achievementList=courseService.findCourseListLevel(level);
    	if(level.equals("country")){
    		levelNow = "国家级";
    	}else if(level.equals("province")){
    		levelNow = "省级";
    	}else{
    		levelNow = "校级";
    	}
		if (achievementList == null) {
			addActionError("对不起，没有符合条件的课程信息，请重新操作！");
			return ERROR;
		} else{
			return SUCCESS;
		}
    }
    

    public String forwardToSuperSearch(){
    	return SUCCESS;
    }
    
    public String forwardToSchoolSearch(){
    	return SUCCESS;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getLevelNow() {
		return levelNow;
	}

	public void setLevelNow(String levelNow) {
		this.levelNow = levelNow;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setIfAttachment(String ifAttachment) {
		this.ifAttachment = ifAttachment;
	}

	public String getIfAttachment() {
		return ifAttachment;
	}

	public void setSearchCourseService(ISearchCourseService searchCourseService) {
		this.searchCourseService = searchCourseService;
	}

	public ISearchCourseService getSearchCourseService() {
		return searchCourseService;
	}

	public void setIdLogin(String idLogin) {
		this.idLogin = idLogin;
	}

	public String getIdLogin() {
		return idLogin;
	}

	public void setAfterLogin(String afterLogin) {
		this.afterLogin = afterLogin;
	}

	public String getAfterLogin() {
		return afterLogin;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
