package cn.edu.xmu.course.test;

import java.util.List;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.edu.xmu.course.commons.MD5;
import cn.edu.xmu.course.pojo.Administrator;
import cn.edu.xmu.course.pojo.Evaluation;
import cn.edu.xmu.course.pojo.School;
import cn.edu.xmu.course.pojo.Student;
import cn.edu.xmu.course.pojo.SuperAdmin;
import cn.edu.xmu.course.pojo.Teacher;
import cn.edu.xmu.course.service.IAdminService;
import cn.edu.xmu.course.service.IEvaluateService;
import cn.edu.xmu.course.service.ISchoolService;
import cn.edu.xmu.course.service.IStudentInfoService;
import cn.edu.xmu.course.service.ITeacherInfoService;

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
		ITeacherInfoService service = (ITeacherInfoService) factory
				.getBean("teacherInfoService");
		IStudentInfoService stuService = (IStudentInfoService) factory
		.getBean("studentInfoService");
		IAdminService adminService = (IAdminService) factory
		.getBean("adminService");
		ISchoolService superAdmin=(ISchoolService) factory
		.getBean("schoolService");		
		IEvaluateService evaService = (IEvaluateService) factory.getBean("evaluateService");
		MD5 md5 = new MD5();
		List<Administrator> admins = adminService.findAllAdmin();
		System.out.println(admins.size());
		for(Administrator a:admins){
			a.setPassword(md5.getMD5ofStr(a.getPassword()));
			adminService.updateAdmin(a);
		}
		List<SuperAdmin> superAdmins =adminService.findAllSuperAdmin();
		for(SuperAdmin sa:superAdmins){
			sa.setPassword(md5.getMD5ofStr(sa.getPassword()));
			adminService.updateSuperAdmin(sa);
		}
		List<School> schools = superAdmin.findAllSchool();
		for(School school:schools){
			List<Student> stus = stuService.findBySchool(school);
			for(Student stu:stus){
				stu.setPassword(md5.getMD5ofStr(stu.getPassword()));
				stuService.updatePassword(stu);
			}
			List<Teacher> teas = service.findTeachersBySchool(school);
			for(Teacher tea :teas){
				tea.setPassword(md5.getMD5ofStr(tea.getPassword()));
				service.updatePassword(tea);
			}
		}
//		List<Evaluation> evas = evaService.findAllEvaluation();
//		for(Evaluation eva:evas){
//			eva.setPassword(md5.getMD5ofStr(eva.getPassword()));
//			evaService.updateEvaluation(eva);
//		}
//		System.out.println("你已经运行成功!");
	}

}
