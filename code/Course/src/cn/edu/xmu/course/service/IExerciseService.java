package cn.edu.xmu.course.service;

import java.io.File;
import java.util.List;

import cn.edu.xmu.course.pojo.Chapter;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.pojo.Exercise;

/**
 * 课程习题
 * @author 何申密
 * @author 许子彦
 *
 */
public interface IExerciseService {

	/**
	 * 查找该课程所有的习题
	 * @param teacherCoures
	 * @return
	 */
	public List<Exercise> getAllExercises(Course course);
	
	/**
	 * 查找该目录下所有的习题
	 * @param chapter
	 * @return
	 */
	public List<Exercise> getExercisesByChapter(Chapter chapter);
	
	/**
	 * 获得该习题
	 * @param id
	 * @return
	 */
	public Exercise getExerciseById(Integer id);
	
	/**
	 * 添加新的习题
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean addExercise(Exercise exercise, Chapter chapter, File upload);

	/**
	 * 添加习题
	 * @param exercise
	 * @param chapter
	 * @return
	 */
	public boolean updateExercise(Exercise exercise, Chapter chapter, File upload);
	
	/**
	 * 删除习题
	 * @param exercise
	 * @return
	 */
	public boolean deleteExercise(Exercise exercise);
}
