package edu.zust.survey.service.impl;

import com.google.common.collect.Lists;
import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.DisplayFormMapper;
import edu.zust.survey.dao.GradeTableMapper;
import edu.zust.survey.dao.MajorMapper;
import edu.zust.survey.dao.QuestionnaireMapper;
import edu.zust.survey.entity.DisplayForm;
import edu.zust.survey.entity.GradeTable;
import edu.zust.survey.entity.Major;
import edu.zust.survey.entity.Questionnaire;
import edu.zust.survey.service.IDisplayFormService;
import edu.zust.survey.vo.GradeChoiceVo;
import edu.zust.survey.vo.IdAndNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
    public boolean modifyDisplayForm(Integer majorId, HttpServletRequest request) {
        Integer grade = Integer.valueOf(request.getParameter("grade"));
        Integer questionnaireId = Integer.valueOf(request.getParameter("questionnaireId"));
        Integer part1 = Integer.valueOf(request.getParameter("part1"));
        Integer part2 = Integer.valueOf(request.getParameter("part2"));
        displayFormMapper.updateByMajorIdAndGrade(
                GenericBuilder.of(DisplayForm::new)
                .with(DisplayForm::setGrade, grade)
                .with(DisplayForm::setQuestionnaireId, questionnaireId)
                .with(DisplayForm::setPart1IsDisplay, part1 == 1)
                .with(DisplayForm::setPart2IsDisplay, part2 == 2)
                .build()
        );
        return true;
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
    public List<GradeChoiceVo> assembleGradeChoiceVos(Integer majorId) {
        List<GradeChoiceVo> gradeChoiceVos = Lists.newArrayList();
        List<DisplayForm> displayForms = displayFormMapper.selectByMajorId(majorId);
        List<Questionnaire> questionnaires = questionnaireMapper.selectByMajorId(majorId);
        List<IdAndNameVo> idAndNameVos = Lists.newArrayList();
        for (Questionnaire q : questionnaires){
            idAndNameVos.add(
                    GenericBuilder.of(IdAndNameVo::new)
                    .with(IdAndNameVo::setId, q.getId())
                    .with(IdAndNameVo::setName, q.getName())
                    .build()
            );
        }
        for (DisplayForm displayForm : displayForms){
            gradeChoiceVos.add(GenericBuilder.of(GradeChoiceVo::new)
                    .with(GradeChoiceVo::setGrade, displayForm.getId())
                    .with(GradeChoiceVo::setCurrentQuestionnaireIdChoice, displayForm.getQuestionnaireId())
                    .with(GradeChoiceVo::setPart1IsDisplay, displayForm.getPart1IsDisplay())
                    .with(GradeChoiceVo::setPart2IsDisplay, displayForm.getPart2IsDisplay())
                    .with(GradeChoiceVo::setPart3IsDisplay, displayForm.getPart3IsDisplay())
                    .with(GradeChoiceVo::setEnable, displayForm.getEnable())
                    .with(GradeChoiceVo::setQuestionnaires, idAndNameVos)
                    .build()
            );
        }
        return null;
    }


}
