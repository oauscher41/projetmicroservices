package fr.dauphine.miageIf.msa.exemple2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class OperationController {
	
	public static final Logger logger = LoggerFactory.getLogger(OperationController.class);
	
	@Autowired
	private OperationChangeRepository op_repository;
	@GetMapping("/devise-change/id_trans/{id}")
	public Optional<OperationChange> retrouveOperationChange
	(@PathVariable int id) {
		Optional<OperationChange> op = op_repository.findById(id);
		logger.info("GET DONE!");
		return op;
	}
	
	@PostMapping("/devise-change/add/")
	public void createOperationChange( 
            @RequestBody OperationChange op) {
		
        
        OperationChange savedop = op_repository.save(op);
        
        logger.info("INSERT DONE!");

    }
	@PutMapping("/devise-change/update/")
	public void updateOperationChange( 
            @RequestBody OperationChange cc) {
	
        OperationChange savedop = op_repository.save(op);
        
        logger.info("UPDATE DONE!");

    }
	@DeleteMapping("/devise-change/delete/{id}")
	public void deleteOperationChange(@PathVariable int id
            ) {
	
         op_repository.deleteById(id);
        
        logger.info("DELETE DONE!");

    }

	
	
}

