package org.com.backend.Services;

import java.util.List;

import org.com.backend.Entity.Worker;
import org.com.backend.IServices.IWorkerService;
import org.com.backend.Repository.WorkerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WorkerService implements IWorkerService {
	
	private final WorkerRepository workerRepository;
	
	public WorkerService(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	@Override
	public ResponseEntity<Worker> saveWorker(Worker worker) {
		
		Worker saveWorker = workerRepository.save(worker);
				
		return ResponseEntity.ok(saveWorker);
	}

	@Override
	public ResponseEntity<Worker> findWorkerById(Long id) {
		
		return workerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<List<Worker>> findAllWorkers() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}

	@Override
	public ResponseEntity<Worker> updateWorker(Long id, Worker worker) {
		
		return workerRepository.findById(id).map(existingWorker -> {

	        existingWorker.setName(worker.getName()); 
	        existingWorker.setEmail(worker.getEmail());
	        existingWorker.setPhoneNumber(worker.getPhoneNumber());
	        existingWorker.setSalary(worker.getSalary());
	        existingWorker.setExperience(worker.getExperience());
	        existingWorker.setAge(worker.getAge());
	        existingWorker.setDateOfBirth(worker.getDateOfBirth());

	        Worker updatedWorker = workerRepository.save(existingWorker);

	        return ResponseEntity.ok(updatedWorker);

	    }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<String> DeleteWorkerById(Long id) {
		
		if(workerRepository.existsById(id)) {
			workerRepository.deleteById(id);
			return ResponseEntity.ok("Worker Deleted Successfully");
		}
		else {
			return ResponseEntity.badRequest().body("Unable to delete the Worker");
		}
		
	}

}
