package cn.edu.xmu.course.service.impl;

import cn.edu.xmu.course.dao.ApplicationFormDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IApplicationFormService;

public class ApplicationFormService implements IApplicationFormService {
	private ApplicationFormDAO applicationFormDAO;
	public boolean addApplicationForm(ApplicationForm applicationForm,
			Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteApplicationForm(ApplicationForm applicationForm) {
		// TODO Auto-generated method stub
		return false;
	}

	public ApplicationForm getApplicationForm(int courseId) {
		
		return (ApplicationForm)applicationFormDAO.findByCourse(courseId).get(0);
	}

	public boolean updateApplicationForm(ApplicationForm applicationForm) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setApplicationFormDAO(ApplicationFormDAO applicationFormDAO) {
		this.applicationFormDAO = applicationFormDAO;
	}

	public ApplicationFormDAO getApplicationFormDAO() {
		return applicationFormDAO;
	}

	
}
