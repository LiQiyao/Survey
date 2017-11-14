package edu.zust.survey.service.impl;

import edu.zust.survey.service.IQuestionnaireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Lee on 2017/11/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class QuestionnaireServiceImplTest {

    @Autowired
    private IQuestionnaireService questionnaireService;

    @Test
    public void createQuestions() throws Exception {
        String jsonString = "{'name':'n新问卷','part1':['n问题1','n问题2'],'part2':[{'questionContent':'n你为什么要自定义问题啊','answerContent':['new知道','不知道']},{'questionContent':'n你为什么要自定义问题2','answerContent':['知道','不知道']}]}";
        //questionnaireService.createQuestionnaire(1, jsonString, null);
        //questionnaireService.deleteQuestionnaireModel(14);
        questionnaireService.modifyQuestionnaireModel(1, 15 ,jsonString);
    }

}