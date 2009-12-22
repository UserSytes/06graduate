package cn.edu.xmu.course.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.ISearchCourseService;

public class SearchCourseServiceTest {
	   String[] locations = {"WebRoot/WEB-INF/actionContext.xml", "WebRoot/WEB-INF/applicationContext.xml", "WebRoot/WEB-INF/daoContext.xml","WebRoot/WEB-INF/serviceContext.xml"};
	FileSystemXmlApplicationContext factory =new FileSystemXmlApplicationContext(locations);
	private ISearchCourseService service =(ISearchCourseService)factory.getBean("searchCourseService");
	
	@Test
	public void testExportCustomersList() {
		List<Course> list=service.findCourseByName("UML");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).getName()+"\n");
		assertEquals(2, list.size());
	}

}
