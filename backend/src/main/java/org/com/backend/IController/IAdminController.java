package org.com.backend.IController;

import java.util.List;
import org.com.backend.Entity.Admin;
import org.springframework.http.ResponseEntity;

public interface IAdminController {
	
	ResponseEntity<Admin> postAdmin(Admin admin);
	
	ResponseEntity<Admin> getAdmin(Long id);
	
	ResponseEntity<List<Admin>> getAllAdmins();
	
	ResponseEntity<Admin> updateAdmin(Long id, Admin admin);
	
	ResponseEntity<String> deleteAdmin(Long id);
}
