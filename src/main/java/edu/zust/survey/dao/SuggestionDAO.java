package edu.zust.survey.dao;

import edu.zust.survey.entity.Student;
import edu.zust.survey.entity.Suggestion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee on 2017/10/19.
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
}
