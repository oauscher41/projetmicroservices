package fr.dauphine.miageIf.msa.exemple;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class ChangeController {
	
	public static final Logger logger = LoggerFactory.getLogger(ChangeController.class);
	
	@Autowired
	private CoursChangeRepository cc_repository;
	@GetMapping("/devise-change/date/{date}/source/{source}/dest/{dest}")
	public CoursChange retrouveCoursChange
	(@PathVariable String date, @PathVariable String source, @PathVariable String dest) {
		CoursChange cc = cc_repository.findByDateAndSourceAndDestination(date, source, dest);
		System.out.println(cc.getId());
		logger.info("GET DONE !! date : " + cc.getDate() + " source : " + cc.getSource() + " dest : " + cc.getDestination() + " taux : " + cc.getTaux());
		return cc;
	}
	
	@PostMapping("/devise-change/add/")
	public CoursChange createCoursChange( 
            @RequestBody CoursChange cc) {
	
        CoursChange savedcc = cc_repository.save(cc);
        
        logger.info("INSERT DONE!");
        
        return savedcc;

    }
	@PutMapping("/devise-change/update/")
	public CoursChange updateCoursChange( 
            @RequestBody CoursChange cc) {
	
        CoursChange savedcc = cc_repository.save(cc);
        
        logger.info("UPDATE DONE!");
        return savedcc;

    }
	@DeleteMapping("/devise-change/delete/{id}")
	public void deleteCoursChange(@PathVariable int id
            ) {
	
         cc_repository.deleteById(id);
        
        logger.info("DELETE DONE!");

    }

	
	
}
