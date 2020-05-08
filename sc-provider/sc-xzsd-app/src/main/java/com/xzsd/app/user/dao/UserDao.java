package com.xzsd.app.user.dao;
import com.xzsd.app.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserDao
 * @Description 用户管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface UserDao {
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);
    /**
     * 获取用户信息
     * @return 用户信息
     */
    UserInfo findUserById(@Param("userId") String userId);
    /**
     * 修改密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserPasswordById(UserInfo userInfo);
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAccountOrPhone(UserInfo userInfo);
}
