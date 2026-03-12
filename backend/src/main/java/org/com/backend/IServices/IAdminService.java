package org.com.backend.IServices;

import java.util.List;
import org.com.backend.Entity.Admin;
import org.springframework.http.ResponseEntity;

public interface IAdminService {
	
	ResponseEntity<Admin> saveAdmin(Admin admin);
	
	ResponseEntity<Admin> findAdminById(Long id);
	
	ResponseEntity<List<Admin>> findAllAdmins();
	
	ResponseEntity<Admin> updateAdmin(Long id, Admin admin);
	
	ResponseEntity<String> deleteAdminById(Long id);
}
