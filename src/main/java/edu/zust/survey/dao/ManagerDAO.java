package edu.zust.survey.dao;

import edu.zust.survey.entity.Manager;
import edu.zust.survey.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

/**
 * Created by Lee on 2017/10/19.
 */
@Repository
public class ManagerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean insertManager(Manager manager){
        sessionFactory.getCurrentSession().save(manager);
        return true;
    }

    public Manager selectByUsernameAndPassword(String username, String password){
        Session session = sessionFactory.openSession();
        Manager manager = null;
        Query query = session.createQuery("from manager where username=? and password=?");
        query.setParameter(0, username);
        query.setParameter(1, password);
        if (query.getResultList().size() != 0){
            manager = (Manager) query.getSingleResult();
        }
        session.close();
        System.out.println(manager + "!!!!");
        return manager;
    }

}
