package edu.zust.survey.service.impl;

import edu.zust.survey.dao.StudentDAO;
import edu.zust.survey.dao.SuggestionDAO;
import edu.zust.survey.entity.Student;
import edu.zust.survey.entity.Suggestion;
import edu.zust.survey.service.ISuggestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class SuggestionServiceImpl implements ISuggestionService{

    @Autowired
    private SuggestionDAO suggestionDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    public boolean addSuggestion(Integer studentId, String suggestionContent) {
        if (studentId != null){
            Suggestion suggestion = new Suggestion();
            System.out.println(suggestionContent + "!!!");
            suggestion.setSuggestionContent(suggestionContent);
            Student student = studentDAO.getStudentById(studentId);
            student.setAnswered(1);
            suggestion.setStudent(student);
            suggestionDAO.insertSuggestion(suggestion);
            return true;
        }
        return false;
    }
}
