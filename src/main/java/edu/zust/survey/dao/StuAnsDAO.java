package edu.zust.survey.dao;

import edu.zust.survey.entity.StuAns;
import org.hibernate.Session;
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

    public int queryCountByAnswerId(Integer answerId){
        Session session = sessionFactory.openSession();
        long cnt = (Long) session.createQuery("select count(*) from stu_ans where answerId=?").setParameter(0, answerId).uniqueResult();
        int cnt2 = (int)cnt;
        session.close();
        return cnt2;
    }

}
