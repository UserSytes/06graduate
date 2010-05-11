package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ApplicationFormDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IApplicationFormService;

public class ApplicationFormService implements IApplicationFormService {
	private ApplicationFormDAO applicationFormDAO;

	public boolean addApplicationForm(ApplicationForm applicationForm,
			Course course, File upload) {
		// TODO Auto-generated method stub
		applicationForm.setCourse(course);
		try {			
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + applicationForm.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			}
			else {
				applicationForm.setFileLink("");
				applicationForm.setFilename("");
			}
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

	public boolean updateApplicationForm(ApplicationForm applicationForm,
			File upload) {
		// TODO Auto-generated method stub
		try {			
			if (upload != null) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String fileName = path + "/" + applicationForm.getFileLink();
				File file = new File(fileName);
				if (!FileOperation.copy(upload, file))
					return false;
			}
			else {
				applicationForm.setFileLink("");
				applicationForm.setFilename("");
			}
			applicationFormDAO.merge(applicationForm);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List findApplicationByLevel(Object level) {
		return applicationFormDAO.findByLevel(level);
	}

	public List findApplicationByTime(Date time) {
		return applicationFormDAO.findByProperty("time", time);
	}

	// get and set method
	public void setApplicationFormDAO(ApplicationFormDAO applicationFormDAO) {
		this.applicationFormDAO = applicationFormDAO;
	}

	public ApplicationFormDAO getApplicationFormDAO() {
		return applicationFormDAO;
	}
}
