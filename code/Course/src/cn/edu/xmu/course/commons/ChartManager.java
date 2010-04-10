package cn.edu.xmu.course.commons;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartManager {
	public JFreeChart createBarChart(List<CourseEvaluate> param, String title,
			String abscissa, String ordinate) {
		// ��״ͼͼ�����ɺ���
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < param.size(); i++) {
			CourseEvaluate c = param.get(i);
			dataset.addValue(Double.parseDouble(c.getStuAvgScore().toString()), "ѧ������" , c.getCourseName()+"_"+c.getTeacherName());
			dataset.addValue(Double.parseDouble(c.getExpertAvgScore().toString()), "ר������" , c.getCourseName()+"_"+c.getTeacherName());
			dataset.addValue(Double.parseDouble(c.getTeacherAvgScore().toString()), "��ʦ����" , c.getCourseName()+"_"+c.getTeacherName());
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D(title,// ͼ������
				abscissa,// ������
				ordinate,// ������
				dataset,// �����
				PlotOrientation.VERTICAL, true, true, false);
		return chart;
	}

}
