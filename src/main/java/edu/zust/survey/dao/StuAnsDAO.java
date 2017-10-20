package edu.zust.survey.dao;

import edu.zust.survey.entity.StuAns;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee on 2017/10/19.
 */
@Repository
public class StuAnsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean insertStuAns(StuAns stuAns){
        sessionFactory.getCurrentSession().save(stuAns);
        return true;
    }

}
