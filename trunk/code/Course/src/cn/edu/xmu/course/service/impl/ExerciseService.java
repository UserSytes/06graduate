package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExerciseDAO;
import cn.edu.xmu.course.dao.NoticeDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.pojo.Notice;
import cn.edu.xmu.course.service.IExerciseService;

public class ExerciseService implements IExerciseService {

	private ExerciseDAO exerciseDAO;
	private NoticeDAO noticeDAO;

	public boolean addExercise(Exercise exercise, Chapter chapter, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + exercise.getFileLink();
		File file = new File(fileName);
		exercise.setChapter(chapter);
		exercise.setTime(Calendar.getInstance().getTime());
		String title = "添加作业习题《"+exercise.getTitle()+"》";
		String content = "<p>添加最新作业习题《"+exercise.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				exerciseDAO.save(exercise);
				getNoticeDAO().save(notice);
				return true;
			}				
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		try {
			exerciseDAO.delete(exercise);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List getAllExercises(Course course) {
		// TODO Auto-generated method stub
		return exerciseDAO.findByCourse(course.getId());
	}

	public Exercise getExerciseById(Integer id) {
		// TODO Auto-generated method stub
		return exerciseDAO.findById(id);
	}

	public List getExercisesByChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		List<Exercise> exerciseList = exerciseDAO.findByChapter(chapter);
		if (exerciseList.size() > 0)
			return exerciseList;
		else
			return null;
	}

	public boolean updateExercise(Exercise exercise, Chapter chapter,
			File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + exercise.getFileLink();
		File file = new File(fileName);
		exercise.setChapter(chapter);
		exercise.setTime(Calendar.getInstance().getTime());
		String title = "修改作业习题《"+exercise.getTitle()+"》";
		String content = "<p>修改已有作业习题《"+exercise.getTitle()+"》，请同学们注意查阅。</p>";
		Notice notice = new Notice(chapter.getCourse(),title,content,new Date(),1);	
		try {			
			if (FileOperation.copy(upload, file)){
				exerciseDAO.merge(exercise);
				getNoticeDAO().save(notice);
				return true;			
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void setExerciseDAO(ExerciseDAO exerciseDAO) {
		this.exerciseDAO = exerciseDAO;
	}

	public ExerciseDAO getExerciseDAO() {
		return exerciseDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

}
