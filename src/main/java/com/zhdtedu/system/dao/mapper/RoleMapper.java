package com.zhdtedu.system.dao.mapper;

import com.zhdtedu.system.dao.entity.Role;
import com.zhdtedu.system.dao.entity.RoleExample;
import java.util.List;

import com.zhdtedu.system.dao.entity.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roles
     *
     * @mbg.generated Thu Jul 25 09:56:50 CST 2019
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);
    List<Role> selectByExample2();
    int getTotalCount();
    int deleteByRole(int id);
    int  updateByPrimaryKey(@Param("record") Role role);
    int getTotalCountBy();
    Role getRole(@Param("roleId")int roleId);
}