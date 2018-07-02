package fr.dauphine.miageIf.msa.exemple2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OperationController {
	
	public static final Logger logger = LoggerFactory.getLogger(OperationController.class);
	
	@Autowired
	private OperationChangeRepository op_repository;
	@Autowired
	@GetMapping("/devise-change/get_operation/{id}")
	public Optional<OperationChange> retrouveOperationChange
	(@PathVariable int id) {
		Optional<OperationChange> op = op_repository.findById(id);
		logger.info("GET DONE!");
		return op;
	}
	
	@PostMapping("/devise-change/new_operation/")
	public void createOperationChange( 
            @RequestBody OperationChange op) {
		
		RestTemplate restTemplate = new RestTemplate();
		String date = op.getDate();
		String source = op.getSource();
		String dest = op.getDestination();
		
		String ResourceUrl = "http://localhost:8000/devise-change/date/"+date+"/source/"+source+"/dest/"+dest;
		
		ResponseEntity<String> response = restTemplate.getForEntity(ResourceUrl, String.class);
		response.toString()
        
        OperationChange savedop = op_repository.save(op);
        
        logger.info("INSERT DONE!");

    }
	@PutMapping("/devise-change/update_operation/")
	public void updateOperationChange( 
            @RequestBody OperationChange op) {
	
        OperationChange savedop = op_repository.save(op);
        
        logger.info("UPDATE DONE!");

    }
	@DeleteMapping("/devise-change/delete_operation/{id}")
	public void deleteOperationChange(@PathVariable int id
            ) {
	
         op_repository.deleteById(id);
        
        logger.info("DELETE DONE!");

    }

	
	
}

