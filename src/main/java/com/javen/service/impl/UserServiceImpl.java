package com.javen.service.impl;
import com.javen.dao.TbUserDao;
import com.javen.model.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javen.service.IUserService;
  
  
@Service
public class UserServiceImpl implements IUserService {  
    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.tbUserDao.getUserById(userId);
    }  
  
}  
