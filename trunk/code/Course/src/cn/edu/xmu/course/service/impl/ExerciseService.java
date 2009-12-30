package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ExerciseDAO;
import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Exercise;
import cn.edu.xmu.course.service.IExerciseService;

public class ExerciseService implements IExerciseService {

	private ExerciseDAO exerciseDAO;

	public boolean addExercise(Exercise exercise, Chapter chapter, File upload) {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		String fileName = path + "/" + exercise.getFileLink();
		File file = new File(fileName);
		exercise.setChapter(chapter);
		exercise.setTime(Calendar.getInstance().getTime());
		try {
			exerciseDAO.save(exercise);
			if (FileOperation.copy(upload, file))
				return true;
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
		return exerciseDAO.findByChapter(chapter);
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
		try {
			exerciseDAO.merge(exercise);
			if (FileOperation.copy(upload, file))
				return true;
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

}
