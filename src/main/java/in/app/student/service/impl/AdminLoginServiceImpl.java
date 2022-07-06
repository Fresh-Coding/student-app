package in.app.student.service.impl;

import in.app.student.dao.AdminLoginDAO;
import in.app.student.dao.GenericDAO;
import in.app.student.entity.AdminLogin;
import in.app.student.service.AdminLoginService;
import in.app.student.utils.MD5Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("adminLoginService")
public class AdminLoginServiceImpl extends GenericServiceImpl<AdminLogin> implements AdminLoginService {

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    @Override
    public GenericDAO<AdminLogin, Integer> getBaseDAO() {
        return adminLoginDAO;
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public AdminLogin findByEmailAndPassword(String email, String password) {
        password = MD5Utility.md5(password);
        return adminLoginDAO.findByEmailAndPassword(email, password);
    }
}
