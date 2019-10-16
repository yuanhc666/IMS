package com.zhdtedu.system.dao.mapper;

import com.zhdtedu.system.dao.entity.UserRole;
import com.zhdtedu.system.dao.entity.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    long countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user_role
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
    int deleteByUserRole(int userId);
}