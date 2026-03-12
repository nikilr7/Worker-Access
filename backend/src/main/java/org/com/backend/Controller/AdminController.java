package org.com.backend.Controller;

import java.util.List;
import org.com.backend.Entity.Admin;
import org.com.backend.IController.IAdminController;
import org.com.backend.Services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
public class AdminController implements IAdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	@PostMapping
	public ResponseEntity<Admin> postAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable Long id) {
		return adminService.findAdminById(id);
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Admin>> getAllAdmins() {
		return adminService.findAllAdmins();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
		return adminService.updateAdmin(id, admin);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
		return adminService.deleteAdminById(id);
	}
}
