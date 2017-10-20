package edu.zust.survey.dao;

import edu.zust.survey.entity.Manager;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        Manager manager = sessionFactory.openSession().createQuery("from manager where username=? and password=?", Manager.class)
                .setParameter(0, username).setParameter(1, password).getSingleResult();
        return manager;
    }

}
