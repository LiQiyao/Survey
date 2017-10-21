package edu.zust.survey.dao;

import edu.zust.survey.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

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
        Student student = null;
        Query query = session.createQuery("from student where username=? and password=?");
        query.setParameter(0, username);
        query.setParameter(1, password);
        if (query.getResultList().size() != 0){
            student = (Student) query.getSingleResult();
        }
        session.close();
        System.out.println(student + "!!!!");
        return student;
    }

    public boolean updateAnsweredStatus(Integer studentId){
        /*Session session = sessionFactory.openSession();
        Student student = session.get(Student.class,studentId);
        student.setAnswered(1);
        session.saveOrUpdate(student);*/
        sessionFactory.getCurrentSession().createNativeQuery("update student set answered = 1 where id=" + studentId).executeUpdate();
        return true;
    }

    public int queryCountSum(Integer majorId){
        Session session = sessionFactory.openSession();
        long cnt = (Long) session.createQuery("select count(*) from student where majorId=?").setParameter(0, majorId).uniqueResult();
        int cnt2=(int)cnt;
        session.close();
        return cnt2;
    }

    public int queryAnsweredCountSum(Integer majorId){
        Session session = sessionFactory.openSession();
        long cnt = (Long) session.createQuery("select count(*) from student where majorId=? and answered = 1").setParameter(0, majorId).uniqueResult();
        int cnt2=(int)cnt;
        session.close();
        return cnt2;
    }

    public Student getStudentById(Integer studentId){
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class,studentId);
        session.close();
        return student;
    }
}
