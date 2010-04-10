package cn.edu.xmu.course.commons;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

public class ServletChartGenerator extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ServletChartGenerator()
	{}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ChartManager cm = new ChartManager();
		OutputStream out = response.getOutputStream();
		try
		{
			HttpSession session = request.getSession();
			List<CourseEvaluate> list= (List<CourseEvaluate>)session.getAttribute("data");
			String title=(String)session.getAttribute("title");
			String abscissa=(String)session.getAttribute("abscissa");
			String ordinate=(String)session.getAttribute("ordinate");
			System.out.println("The title is "+title);
            if(session.getAttribute("data")==null)
            	System.out.println("Session获得参数list为空！");

			JFreeChart chart = null;
		
			if(list!=null)

				chart = cm.createBarChart(list,title,abscissa,ordinate);
			else 
				System.out.println("参数Param为空！");
		
			if (chart != null)
			{
				response.setContentType("image/png");
				ChartUtilities.writeChartAsPNG(out, chart, 800, 600);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}

}