package com.mybatis.mapper;


import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 */
public interface UserMapper {
    List<User> findByCondition(User user);
    
    List<User> findByIds(List<Integer> ids);
    
    User selectByIdAndUsername(int id, String username);
    
    User selectByIdAndUsernameByAnno(@Param("id") int id, @Param("username") String username);
    
    User selectByIdAndUsernameByMap(Map<String, Object> map);
    
    List<User> selectUserByLike(String username);
    
    int insertUser(User user);
}
