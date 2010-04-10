package cn.edu.xmu.course.commons;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartManager {
	public JFreeChart createBarChart(List<CourseEvaluate> param, String title,
			String abscissa, String ordinate) {
		// 柱状图图的生成函数
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < param.size(); i++) {
			CourseEvaluate c = param.get(i);
			dataset.addValue(Double.parseDouble(c.getStuAvgScore().toString()), "学生评价" , c.getCourseName()+"_"+c.getTeacherName());
			dataset.addValue(Double.parseDouble(c.getExpertAvgScore().toString()), "专家评价" , c.getCourseName()+"_"+c.getTeacherName());
			dataset.addValue(Double.parseDouble(c.getTeacherAvgScore().toString()), "教师评价" , c.getCourseName()+"_"+c.getTeacherName());
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D(title,// 图的名称
				abscissa,// 横坐标
				ordinate,// 纵坐标
				dataset,// 结果集
				PlotOrientation.VERTICAL, true, true, false);
		return chart;
	}

}
