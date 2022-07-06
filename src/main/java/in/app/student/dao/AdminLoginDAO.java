package in.app.student.dao;

import in.app.student.entity.AdminLogin;

public interface AdminLoginDAO extends GenericDAO<AdminLogin,Integer> {
    AdminLogin findByEmailAndPassword(String email, String password);
}
