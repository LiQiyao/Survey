package edu.zust.survey.service.impl;

import edu.zust.survey.dao.ManagerDAO;
import edu.zust.survey.entity.Manager;
import edu.zust.survey.service.IManagerService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lee on 2017/10/19.
 */
@Service
public class ManagerServiceImpl implements IManagerService{

    @Autowired
    private ManagerDAO managerDAO;

    @Override
    public Manager login(String username, String password) {
        Manager manager = managerDAO.selectByUsernameAndPassword(username, password);
        manager.setPassword(StringUtils.EMPTY);
        return manager;
    }

    @Override
    @Transactional
    public boolean addManager(String username, String password, Integer majorId) {
        Manager manager = new Manager(username, password, majorId);
        return managerDAO.insertManager(manager);
    }
}
