package cn.edu.xmu.course.commons;

/**
 * �γ�������Ϣ
 * @author ֣����
 *
 */
public class CourseEvaluate implements java.io.Serializable{

	private String courseName; //�γ�����
	private String teacherName; //��ʦ����
	private Object stuAvgScore = 0; //ѧ������
	private Object expertAvgScore = 0; //ר������
	private Object teacherAvgScore = 0; //��ʦ����
	private Object stuCount; //ѧ����������
	private Object expertCount; //ר����������
	private Object teacherCount; //��ʦ��������
	
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
