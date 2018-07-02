package fr.dauphine.miageIf.msa.exemple;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ChangeControllerTests {
 
    //@Autowired
    //private TestEntityManager entityManager;
	public static final Logger logger = LoggerFactory.getLogger(ChangeController.class);
 
    @Autowired
    private CoursChangeRepository ccRepository;
    
 
    
    @Test
    public void whenFindByDateAndSourceAndDestination_thenReturnCoursChange() {
        // given
        CoursChange taux1 = new CoursChange();
        ChangeController result = new ChangeController();
        
        taux1.setDestination("USD");
        taux1.setSource("EUR");
        taux1.setDate("23-04-2018");
        taux1.setId(2001);
        taux1.setTaux((float)1.03);
        
        
        ccRepository.save(taux1);
        ccRepository.flush();
                
     
        // when
        CoursChange cours1 = ccRepository.findByDateAndSourceAndDestination(taux1.getDate(), taux1.getSource(), taux1.getDestination());
        logger.info("GET DONE !! id : " + cours1.getId() + " date : " + cours1.getDate() + " source : " + cours1.getSource() + " dest : " + cours1.getDestination() + " taux : " + cours1.getTaux());
        
        // then
        //assertThat(taux1.getId()).isEqualTo(cours1.getId());
        assertThat(cours1.getDate()).isEqualTo(taux1.getDate());
        assertThat(cours1.getSource()).isEqualTo(taux1.getSource());
        assertThat(cours1.getDestination()).isEqualTo(taux1.getDestination());
        assertThat(cours1.getTaux()).isEqualTo(taux1.getTaux());
    }
    @Test
    public void whenUpdateCoursChange_thenReturnCoursChangeUpdated() {
    	
    	//ChangeController cc = new ChangeController();
    	CoursChange taux = new CoursChange();
    	
    	taux.setDestination("USD");
        taux.setSource("EUR");
        taux.setDate("23-04-2018");
        taux.setId(2001);
        taux.setTaux((float)1.03);
        
        
        //cc.createCoursChange(taux1);
        ccRepository.save(taux);
        ccRepository.flush();
        
        taux.setTaux((float)1.34);
 
        ccRepository.save(taux);
        ccRepository.flush();
        
        CoursChange result = ccRepository.findByDateAndSourceAndDestination(taux.getDate(), taux.getSource(), taux.getDestination());
        logger.info("GET DONE !! id : " + result.getId() + " date : " + result.getDate() + " source : " + result.getSource() + " dest : " + result.getDestination() + " taux : " + result.getTaux());
        
        
        
        assertThat(result.getDate()).isEqualTo(taux.getDate());
        assertThat(result.getSource()).isEqualTo(taux.getSource());
        assertThat(result.getDestination()).isEqualTo(taux.getDestination());
        assertThat(result.getTaux()).isEqualTo(taux.getTaux());
        
    }
 
 
}