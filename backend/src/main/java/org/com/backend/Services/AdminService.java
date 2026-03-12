package org.com.backend.Services;

import java.util.List;
import org.com.backend.Entity.Admin;
import org.com.backend.IServices.IAdminService;
import org.com.backend.Repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
	
	private final AdminRepository adminRepository;
	
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public ResponseEntity<Admin> saveAdmin(Admin admin) {
		Admin savedAdmin = adminRepository.save(admin);
		return ResponseEntity.ok(savedAdmin);
	}

	@Override
	public ResponseEntity<Admin> findAdminById(Long id) {
		return adminRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<List<Admin>> findAllAdmins() {
		List<Admin> admins = adminRepository.findAll();
		return ResponseEntity.ok(admins);
	}

	@Override
	public ResponseEntity<Admin> updateAdmin(Long id, Admin admin) {
		return adminRepository.findById(id).map(existing -> {
			existing.setName(admin.getName());
			existing.setEmail(admin.getEmail());
			existing.setPhoneNumber(admin.getPhoneNumber());
			existing.setAge(admin.getAge());
			existing.setDateOfBirth(admin.getDateOfBirth());
			Admin updatedAdmin = adminRepository.save(existing);
			return ResponseEntity.ok(updatedAdmin);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<String> deleteAdminById(Long id) {
		if(adminRepository.existsById(id)) {
			adminRepository.deleteById(id);
			return ResponseEntity.ok("Admin Deleted Successfully");
		}
		return ResponseEntity.badRequest().body("Unable to delete the Admin");
	}
}
