package edu.zust.survey.service.impl;

import edu.zust.survey.dao.StudentDAO;
import edu.zust.survey.entity.Student;
import edu.zust.survey.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public Student login(String username, String password) {
        System.out.println("///");
        Student student = studentDAO.selectByUsernameAndPassword(username, password);
        //student.setPassword(StringUtils.EMPTY);
        return student;
    }

}
