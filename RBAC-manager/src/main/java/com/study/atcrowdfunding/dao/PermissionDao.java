package com.study.atcrowdfunding.dao;

import java.util.List;

import com.study.atcrowdfunding.bean.Permission;
import com.study.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;




public interface PermissionDao {

	@Select("select * from t_permission where pid is null")
	Permission queryRootPermission();

	@Select("select * from t_permission where pid = #{pid}")
	List<Permission> queryChildPermissions(Integer pid);

	@Select("select * from t_permission")
	List<Permission> queryAll();

	void insertPermission(Permission permission);

	@Select("select * from t_permission where id = #{id}")
	Permission queryById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	@Select("select permissionid from t_role_permission where roleid = #{roleid}")
	List<Integer> queryPermissionidsByRoleid(Integer roleid);

	List<Permission> queryPermissionsByUser(User dbUser);

}
