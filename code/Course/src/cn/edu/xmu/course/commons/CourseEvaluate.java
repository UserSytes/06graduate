package cn.edu.xmu.course.commons;

/**
 * 课程评价信息
 * @author 郑冰凌
 *
 */
public class CourseEvaluate implements java.io.Serializable{

	private String courseName; //课程名称
	private String teacherName; //教师姓名
	private Object stuAvgScore = 0; //学生评价
	private Object expertAvgScore = 0; //专家评价
	private Object teacherAvgScore = 0; //教师评价
	private Object stuCount; //学生评价人数
	private Object expertCount; //专家评价人数
	private Object teacherCount; //教师评价人数
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Object getStuAvgScore() {
		return stuAvgScore;
	}
	public void setStuAvgScore(Object stuAvgScore) {
		this.stuAvgScore = stuAvgScore;
	}
	public Object getExpertAvgScore() {
		return expertAvgScore;
	}
	public void setExpertAvgScore(Object expertAvgScore) {
		this.expertAvgScore = expertAvgScore;
	}
	public Object getTeacherAvgScore() {
		return teacherAvgScore;
	}
	public void setTeacherAvgScore(Object teacherAvgScore) {
		this.teacherAvgScore = teacherAvgScore;
	}
	public Object getStuCount() {
		return stuCount;
	}
	public void setStuCount(Object stuCount) {
		this.stuCount = stuCount;
	}
	public Object getExpertCount() {
		return expertCount;
	}
	public void setExpertCount(Object expertCount) {
		this.expertCount = expertCount;
	}
	public Object getTeacherCount() {
		return teacherCount;
	}
	public void setTeacherCount(Object teacherCount) {
		this.teacherCount = teacherCount;
	}
	
	
}
