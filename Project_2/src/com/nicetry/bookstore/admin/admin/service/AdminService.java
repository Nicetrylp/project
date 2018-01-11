package com.nicetry.bookstore.admin.admin.service;

import com.nicetry.bookstore.admin.admin.dao.AdminDao;
import com.nicetry.bookstore.admin.admin.domain.Admin;
import com.nicetry.bookstore.admin.admin.service.exception.AdminNameErrorException;
import com.nicetry.bookstore.admin.admin.service.exception.LoginException;
import com.nicetry.bookstore.admin.admin.service.exception.PasswordErrorException;

public class AdminService {
    AdminDao adminDao = new AdminDao();
    public void login(Admin admin) throws LoginException{
        Admin admin1 = adminDao.queryByName(admin.getAdminName());
        if (admin1 == null){
            //TODO 异常
            throw new AdminNameErrorException();
        }
        if (!admin1.getAdminPassword().equals(admin.getAdminPassword())){
            // 异常
            throw new PasswordErrorException();
        }
        return;
    }
}
