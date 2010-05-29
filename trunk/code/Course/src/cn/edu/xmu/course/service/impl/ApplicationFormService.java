package cn.edu.xmu.course.service.impl;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.edu.xmu.course.commons.FileOperation;
import cn.edu.xmu.course.dao.ApplicationFormDAO;
import cn.edu.xmu.course.pojo.ApplicationForm;
import cn.edu.xmu.course.pojo.Course;
import cn.edu.xmu.course.service.IApplicationFormService;

/**
 * 申报表格
 * @author 何申密
 * @author 许子彦
 *
 */
public class ApplicationFormService implements IApplicationFormService {
	private ApplicationFormDAO applicationFormDAO;

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IApplicationFormService#addApplicationForm(cn.edu.xmu.course.pojo.ApplicationForm, cn.edu.xmu.course.pojo.Course, java.io.File)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IApplicationFormService#deleteApplicationForm(cn.edu.xmu.course.pojo.ApplicationForm)
	 */
	public boolean deleteApplicationForm(ApplicationForm applicationForm) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IApplicationFormService#getApplicationForm(int)
	 */
	public ApplicationForm getApplicationForm(int courseId) {
		List<ApplicationForm> applicationForms = applicationFormDAO
				.findByCourse(courseId);
		if (applicationForms.size() > 0)
			return applicationForms.get(0);
		else
			return null;
	}	
	
	/*
	 * (non-Javadoc)
	 * @see cn.edu.xmu.course.service.IApplicationFormService#updateApplicationForm(cn.edu.xmu.course.pojo.ApplicationForm, java.io.File)
	 */
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

	// get and set method
	public void setApplicationFormDAO(ApplicationFormDAO applicationFormDAO) {
		this.applicationFormDAO = applicationFormDAO;
	}

	public ApplicationFormDAO getApplicationFormDAO() {
		return applicationFormDAO;
	}
}
