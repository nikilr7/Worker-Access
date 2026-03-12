package org.com.backend.IServices;

import java.util.List;

import org.com.backend.Entity.Worker;
import org.springframework.http.ResponseEntity;

public interface IWorkerService {
	
	ResponseEntity<Worker> saveWorker(Worker worker);
	
	ResponseEntity<Worker> findWorkerById(Long id);
	
	ResponseEntity<List<Worker>> findAllWorkers();
	
	ResponseEntity<Worker> updateWorker(Long id,Worker worker);
	
	ResponseEntity<String> DeleteWorkerById(Long id);
}
