package com.javen.dao;

import com.javen.model.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @author created by xujn14
 * @date 2017-11-10 10:32
 **/

public interface TbUserDao {
    public TbUser getUserById(int userId);
}
