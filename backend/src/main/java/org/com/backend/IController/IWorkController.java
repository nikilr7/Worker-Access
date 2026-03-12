package org.com.backend.IController;

import java.util.List;

import org.com.backend.Entity.Worker;
import org.springframework.http.ResponseEntity;

public interface IWorkController {
	
	ResponseEntity<Worker> postWorker(Worker worker);
	
	ResponseEntity<Worker> getWorker(Long id);
	
	ResponseEntity<List<Worker>> getAllWorkers();
	
	ResponseEntity<Worker> updateWorker(Long id,Worker worker);
	
	ResponseEntity<String> deleteWorker(Long id);
	
}
