package cn.edu.xmu.course.service.impl;

import java.util.List;

import cn.edu.xmu.course.dao.ApplicationFormDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IApplicationFormService;

public class ApplicationFormService implements IApplicationFormService {
	private ApplicationFormDAO applicationFormDAO;

	public boolean addApplicationForm(ApplicationForm applicationForm,
			Course course) {
		// TODO Auto-generated method stub
		applicationForm.setCourse(course);
		try {
			applicationFormDAO.save(applicationForm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteApplicationForm(ApplicationForm applicationForm) {
		// TODO Auto-generated method stub
		return false;
	}

	public ApplicationForm getApplicationForm(int courseId) {
		List<ApplicationForm> applicationForms = applicationFormDAO
				.findByCourse(courseId);
		if (applicationForms.size() > 0)
			return applicationForms.get(0);
		else
			return null;
	}

	public boolean updateApplicationForm(ApplicationForm applicationForm) {
		// TODO Auto-generated method stub
		try {
			applicationFormDAO.merge(applicationForm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setApplicationFormDAO(ApplicationFormDAO applicationFormDAO) {
		this.applicationFormDAO = applicationFormDAO;
	}

	public ApplicationFormDAO getApplicationFormDAO() {
		return applicationFormDAO;
	}

}
