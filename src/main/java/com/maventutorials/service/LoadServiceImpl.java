package com.maventutorials.service;

import com.maventutorials.dao.LoadDao;
import com.maventutorials.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadDao loadDao;

    @Override
    public List<User> getAllUser() {

        return this.loadDao.getAllUser();
    }
}
