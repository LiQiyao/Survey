package edu.zust.survey.dao;

import edu.zust.survey.entity.Student;
import edu.zust.survey.entity.Suggestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lee on 2017/10/19.
 * Changed by Rin.
 */
@Repository
public class SuggestionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean insertSuggestion(Suggestion suggestion){
        System.out.println(suggestion);
        sessionFactory.getCurrentSession().save(suggestion);
        return true;
    }

    public List<Suggestion> querySuggestions(int majorId){
        Session session = sessionFactory.openSession();
        List<Suggestion> suggestionList=session
                .createQuery("from suggestion sug where sug.student.majorId = ?",Suggestion.class)
                .setParameter(0,majorId)
                .getResultList();
        return suggestionList;
    }
}
