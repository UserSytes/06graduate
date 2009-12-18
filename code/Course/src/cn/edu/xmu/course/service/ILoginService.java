package cn.edu.xmu.course.service;

import cn.edu.xmu.course.pojo.Teacher;

public interface ILoginService {

	public Teacher login(String account, String password);
}
