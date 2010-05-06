package cn.edu.xmu.course.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.edu.xmu.course.pojo.Department;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.service.ISearchCourseService;
import cn.edu.xmu.course.service.ISuperAdminService;

public class TEst2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] locations = { "WebRoot/WEB-INF/actionContext.xml",
				"WebRoot/WEB-INF/applicationContext.xml",
				"WebRoot/WEB-INF/daoContext.xml",
				"WebRoot/WEB-INF/serviceContext.xml" };
		FileSystemXmlApplicationContext factory = new FileSystemXmlApplicationContext(
				locations);
		ISearchCourseService service = (ISearchCourseService) factory
				.getBean("searchCourseService");
		ISuperAdminService superAdmin=(ISuperAdminService) factory
		.getBean("superAdminService");		
		File file = new File("D:" + "/" + "dept_data.txt");
		System.out.println(file.getPath());
		List<School> schools = superAdmin.findAllSchool();
		try {
			if (file.exists())
				file.delete();
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file, true);
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			int slength = schools.size();
			for (int i = 0; i < slength; i++) {
				sb.append("{");
				sb.append("\"sort\":2,");
				sb.append("\"id\":" + schools.get(i).getId() + ",");
				sb.append("\"text\":\"" + schools.get(i).getName() + "\",");
				sb.append("\"state\":\"closed\",");
				sb.append("\"children\":[");
				List<Department> depts = superAdmin
						.findDepartmentBySchool(schools.get(i));
				int dlength = depts.size();
				if (dlength > 0) {
					for (int j = 0; j < dlength; j++) {
						sb.append("{");
						sb.append("\"sort\":3,");
						sb.append("\"id\":" + depts.get(j).getId() + ",");
						sb
								.append("\"text\":\"" + depts.get(j).getName()
										+ "\"");
						sb.append("}");
						if (j < (dlength - 1))
							sb.append(",");
					}
				}
				sb.append("]}");
				if (i < (slength - 1))
					sb.append(",");
			}
			sb.append("]");
			out.write(sb.toString().getBytes("utf-8"));
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
