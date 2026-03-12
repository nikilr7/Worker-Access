package org.com.backend.Controller;

import java.util.List;

import org.com.backend.Entity.Worker;
import org.com.backend.IController.IWorkController;
import org.com.backend.Services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Worker")
public class WorkerController implements IWorkController   {
	
	private final WorkerService workerService;
	
	public WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}

	@Override
	@PostMapping
	public ResponseEntity<Worker> postWorker(Worker worker) {
		 
		return workerService.saveWorker(worker);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Worker> getWorker(@PathVariable Long id) {
		
		return workerService.findWorkerById(id);
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Worker>> getAllWorkers() {
		
		return workerService.findAllWorkers();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker worker) {
		
		return workerService.updateWorker(id, worker);
	}

	@Override
	@DeleteMapping
	public ResponseEntity<String> deleteWorker(Long id) {
		
		return workerService.DeleteWorkerById(id);
	}
	
	

}
