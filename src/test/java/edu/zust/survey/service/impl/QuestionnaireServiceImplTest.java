package edu.zust.survey.service.impl;

import edu.zust.survey.service.IManagerService;
import edu.zust.survey.service.IQuestionnaireService;
import edu.zust.survey.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Lee on 2017/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class QuestionnaireServiceImplTest {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IStudentService studentService;

    @Test
    public void createQuestions() throws Exception {
        String jsonString = "{'name':'n新问卷','part1':['n问题1','n问题2'],'part2':[{'questionContent':'n你为什么要自定义问题啊','answerContent':['new知道','不知道']},{'questionContent':'n你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        //questionnaireService.createQuestionnaire(1, jsonString, null);
        //questionnaireService.deleteQuestionnaireModel(14);
        //questionnaireService.modifyQuestionnaireModel(1, 15 ,jsonString);
        //managerService.addGrade(1, 2017);
        Map<String,String[]> map = new HashMap<>();
        map.put("1", new String[]{"1"});
        map.put("2", new String[]{"2"});
        map.put("3", new String[]{"2"});
        map.put("4", new String[]{"1"});
        map.put("suggestionContent", new String[]{"没有意见"});
        studentService.answerQuestions(1, map);
    }
}