package com.grasswort.beans.beandifinition;

import java.util.List;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/5
 */
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public Long addUser(User user) {
        return userRepository.addUser(user);
    }

    /**
     * 查询用户
     * @param userId
     * @return
     */
    public User selectUser(Long userId) {
        return userRepository.selectUser(userId);
    }

    /**
     * 用户列表
     * @return
     */
    public List<User> listUser() {
        return userRepository.listUser();
    }

}
