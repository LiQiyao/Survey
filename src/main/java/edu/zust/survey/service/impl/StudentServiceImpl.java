package edu.zust.survey.service.impl;

import edu.zust.survey.dao.StuAnsMapper;
import edu.zust.survey.dao.StudentMapper;
import edu.zust.survey.dao.SuggestionMapper;
import edu.zust.survey.entity.StuAns;
import edu.zust.survey.entity.Student;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Autowired
    private StuAnsMapper stuAnsMapper;

    @Override
    public Student login(String username, String password) {
        Student student = studentMapper.selectByUsernameAndPassword(username, password);
        //student.setPassword(StringUtils.EMPTY);
        return student;
    }

    @Transactional
    public boolean answerQuestions(Integer studentId, Map<String, String[]> map) {
        String[] temp;
        String value;
        for (String key : map.keySet()){
            temp = map.get(key);
            value = temp[0];
            System.out.println(key + " " + value +"!!!");
            if ("suggestionContent".equals(key)){
                suggestionMapper.insertSelective(new Suggestion(studentId, value));
            } else {
                stuAnsMapper.insert(new StuAns(studentId, Integer.parseInt(key), Integer.parseInt(value)));
            }
        }
        Student updatedStudent = new Student();
        updatedStudent.setAnswered(1);
        studentMapper.updateByPrimaryKeySelective(updatedStudent);
        return true;
    }


}
