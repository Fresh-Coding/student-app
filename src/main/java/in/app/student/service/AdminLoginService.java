package in.app.student.service;

import in.app.student.entity.AdminLogin;

public interface AdminLoginService extends GenericService<AdminLogin>{
    AdminLogin findByEmailAndPassword(String email, String password);
}
