package com.javen.dao.impl;

import com.javen.dao.TbUserDao;
import com.javen.mapper.TbUserMapper;
import com.javen.model.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author created by xujn14
 * @date 2017-11-10 10:32
 **/
@Repository
public class TbUserDaoImpl implements TbUserDao {
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser getUserById(int userId){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(userId);
        return tbUser;
    }
}
