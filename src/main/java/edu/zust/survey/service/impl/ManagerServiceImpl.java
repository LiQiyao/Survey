package edu.zust.survey.service.impl;

import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.DisplayFormMapper;
import edu.zust.survey.dao.GradeTableMapper;
import edu.zust.survey.dao.ManagerMapper;
import edu.zust.survey.dao.QuestionnaireMapper;
import edu.zust.survey.entity.DisplayForm;
import edu.zust.survey.entity.GradeTable;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IDisplayFormService;
import edu.zust.survey.service.IManagerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class ManagerServiceImpl implements IManagerService{

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private GradeTableMapper gradeTableMapper;

    @Autowired
    private IDisplayFormService displayFormService;

    @Override
    public Manager login(String username, String password) {
        Manager manager = managerMapper.selectByUsernameAndPassword(username, password);
        if (manager != null){
            manager.setPassword(StringUtils.EMPTY);
        }
        return manager;
    }

    @Override
    @Transactional
    public boolean addManager(String username, String password, Integer majorId) {
        Manager manager = new Manager(username, password, majorId);
        managerMapper.insert(manager);
        return true;
    }

    @Override
    @Transactional
    public boolean addGrade(Integer majorId, Integer grade) {
        gradeTableMapper.insertSelective(GenericBuilder.of(GradeTable::new)
                                    .with(GradeTable::setGrade, grade)
                                    .with(GradeTable::setMajorId, majorId)
                                    .build());
        /*List<Integer> allQuestionnaireIds = questionnaireMapper.selectAllId();
        for (Integer questionnaireId : allQuestionnaireIds){
            displayFormMapper.insertSelective(GenericBuilder.of(DisplayForm::new)
                    .with(DisplayForm::setGrade, grade)
                    .with(DisplayForm::setQuestionnaireId, questionnaireId)
                    .build());
        }*/
        displayFormService.synchronizeDisplayForm();
        return true;
    }
}
