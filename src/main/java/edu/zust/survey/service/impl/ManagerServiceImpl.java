package edu.zust.survey.service.impl;

import edu.zust.survey.common.GenericBuilder;
import edu.zust.survey.dao.*;
import edu.zust.survey.entity.*;
import edu.zust.survey.service.IDisplayFormService;
import edu.zust.survey.service.IManagerService;
import edu.zust.survey.util.HTML2WordUtil;
import edu.zust.survey.vo.AnswerSheetVo;
import edu.zust.survey.vo.QuestionAndAnswerEntry;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class ManagerServiceImpl implements IManagerService{

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private GradeTableMapper gradeTableMapper;

    @Autowired
    private IDisplayFormService displayFormService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StuAnsMapper stuAnsMapper;

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Autowired
    private DisplayFormMapper displayFormMapper;

    @Autowired
    private MajorMapper majorMapper;

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

    @Override
    public AnswerSheetVo assembleAnswerSheetVo(Integer studentId) {
        Student student = studentMapper.selectByPrimaryKey(studentId);
        logger.info("student: " + student);
/*        int questionnaireId = majorMapper.selectByPrimaryKey(student.getMajorId()).getDisplayQuestionnaireId();
        DisplayForm displayForm = displayFormMapper.selectByQuestionnaireIdAndGrade(questionnaireId, student.getGrade());

        boolean part1IsDisplay = displayForm.getPart1IsDisplay();
        boolean part2IsDisplay = displayForm.getPart2IsDisplay();
        List<QuestionAndAnswerEntry> part1 =null;
        List<QuestionAndAnswerEntry> part2 =null;
        if (part1IsDisplay){
            part1 = stuAnsMapper.selectByStudentIdAndType(studentId, 1);
        }
        if (part2IsDisplay){
            part2 = stuAnsMapper.selectByStudentIdAndType(studentId, 2);
        }
        String suggestionContent = suggestionMapper.selectContentByStudentId(studentId);*/
        return GenericBuilder.of(AnswerSheetVo::new)
                .with(AnswerSheetVo::setStudent, student)
/*                .with(AnswerSheetVo::setPart1, part1)
                .with(AnswerSheetVo::setPart2, part2)
                .with(AnswerSheetVo::setSuggestionContent, suggestionContent)*/
                .build();
    }

    /**
     *
     * @param majorId
     * @param grade
     */
    @Override
    public void getAllAnswerSheet(Integer majorId, Integer grade, String rootPath) {
        List<Integer> studentIds = studentMapper.selectAllIdByMajorIdAndGrade(majorId, grade);
        StringBuilder baseUrl = new StringBuilder("localhost:8080").append(rootPath).append("/admin/answerSheets/");
        logger.info("baseUrl:" + baseUrl);
        logger.info("rootPath:" + rootPath);
        for (Integer studentId : studentIds){
            HTML2WordUtil.generatorWordFile(rootPath + "/Documents/", studentId + ".doc", baseUrl.append(studentId).toString());
        }
    }
}
