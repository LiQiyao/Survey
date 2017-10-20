package edu.zust.survey.dao;

import com.google.gson.Gson;
import edu.zust.survey.entity.Answer;
import edu.zust.survey.entity.Question;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 */
@Repository
public class QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Question> getPart1(Integer majorId){
        List<Question> questions = sessionFactory.openSession().
                createQuery("from question where majorId=? and type=1", Question.class).setParameter(0, majorId).list();
        System.out.println(questions);
        return questions;
    }

    public List<Question> getPart2(Integer majorId){
        List<Question> questions = sessionFactory.openSession().
                createQuery("from question where majorId=? and type=2", Question.class).setParameter(0, majorId).list();
        System.out.println(questions);
        return questions;
    }


    public boolean insertQuestion(Question question){
        sessionFactory.getCurrentSession().save(question);
        return true;
    }


    public boolean deleteQuestion(Integer majorId){
        System.out.println("~~~~" + majorId);
        sessionFactory.getCurrentSession().createQuery("delete from question q where q.majorId=?").setParameter(0, majorId).executeUpdate();
        return true;
    }
}
