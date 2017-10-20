package edu.zust.survey.dao;

import edu.zust.survey.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Lee on 2017/10/19.
 */
@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Student selectByUsernameAndPassword(String username, String password){
        System.out.println("???");
        Session session = sessionFactory.openSession();
        Student student = session.createQuery("from student where username=? and password=?", Student.class).setParameter(0, username).setParameter(1, password).getSingleResult();
        session.close();
        System.out.println(student + "!!!!");
        return student;
    }

    public boolean updateAnsweredStatus(Integer studentId){
        sessionFactory.getCurrentSession().createQuery("update student st set st.answered = 1 where st.id=?").setParameter(0, studentId).executeUpdate();
        return true;
    }

    public Integer queryCountSum(Integer majorId){
        Session session = sessionFactory.openSession();
        Integer cnt = (Integer) session.createQuery("select count(*) from student where majorId=?").setParameter(0, majorId).uniqueResult();
        session.close();
        return cnt;
    }

    public Integer queryAnsweredCountSum(Integer majorId){
        Session session = sessionFactory.openSession();
        Integer cnt = (Integer) session.createQuery("select count(*) from student where majorId=? and answered = 1").setParameter(0, majorId).uniqueResult();
        session.close();
        return cnt;
    }
}
