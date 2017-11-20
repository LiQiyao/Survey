package edu.zust.survey.service.impl;

import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.DisplayFormMapper;
import edu.zust.survey.dao.GradeTableMapper;
import edu.zust.survey.dao.MajorMapper;
import edu.zust.survey.dao.QuestionnaireMapper;
import edu.zust.survey.entity.DisplayForm;
import edu.zust.survey.entity.GradeTable;
import edu.zust.survey.entity.Major;
import edu.zust.survey.service.IDisplayFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lee on 2017/11/15.
 */
@Service
public class DisplayFormServiceImpl implements IDisplayFormService {

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private DisplayFormMapper displayFormMapper;

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    @Autowired
    private GradeTableMapper gradeTableMapper;

    @Override
    @Transactional
    public boolean modifyDisplayForm(Integer displayFormId, boolean[] partIsShow) {
        DisplayForm displayForm = GenericBuilder.of(DisplayForm::new)
                .with(DisplayForm::setId, displayFormId)
                .with(DisplayForm::setPart1IsDisplay, partIsShow[0])
                .with(DisplayForm::setPart2IsDisplay, partIsShow[1])
                .with(DisplayForm::setPart3IsDisplay, partIsShow[2])
                .build();
        int resultCount = displayFormMapper.updateByPrimaryKeySelective(displayForm);
        return resultCount > 0;
    }

    @Override
    public List<DisplayForm> getDisplayFormsByMajorId(Integer majorId) {
        return displayFormMapper.selectByMajorId(majorId);
    }

    @Override
    public boolean synchronizeDisplayForm() {
        List<Integer> questionnaireIds = questionnaireMapper.selectAllId();
        List<Integer> grades = gradeTableMapper.selectAllGrade();
        Set<DisplayForm> displayForms = new HashSet<>(displayFormMapper.selectAll());
        DisplayForm displayForm;
        for (Integer questionnaireId : questionnaireIds){
            for (Integer grade : grades){
                displayForm = GenericBuilder
                        .of(DisplayForm::new)
                        .with(DisplayForm::setGrade, grade)
                        .with(DisplayForm::setQuestionnaireId, questionnaireId)
                        .build();
                if (!displayForms.contains(displayForm)){
                    displayFormMapper.insertSelective(displayForm);
                }
            }
        }
        return false;
    }

    @Override
    public List<DisplayForm> getDisplayForms(Integer questionnaireId) {
        return displayFormMapper.selectByQuestionnaireId(questionnaireId);
    }
}
