package com.hysf.dao.impl;

import com.hysf.dao.BaseDao;
import com.hysf.dao.UserDao;
import com.hysf.Permission.Permission;
import com.hysf.entity.User;
import com.hysf.entity.product;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        return queryByOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ? ";
        return queryByOne(User.class, sql, username, password);
    }

    @Override
    public List<product> queryProduct() {
        String sql = "select * from product ";
        return queryByList(product.class, sql);
    }

    @Override
    public product queryProduct(int product_id) {
        String sql = "select * from product where product_id = ?";
        return queryByOne(product.class, sql, product_id);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user (username, password,email,gender,hobby) values(?,?,?,?,?)";

        return update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getGender(),
                user.getHobby());
    }


    //赋予权限
    @Override
    public void addUserPermissions(long userId, List<Permission> permissions) {
        // 这里是添加权限到数据库的实现
        // 例如，使用循环插入到 user_permissions 表中
        for (Permission permission : permissions) {
            String sql = "INSERT INTO user_permissions (user_id, permission_name) VALUES (?, ?)";
            update(sql, userId, permission.name());
        }
    }
}