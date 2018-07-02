import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChangeControllerTests {
 
    //@Autowired
    //private TestEntityManager entityManager;
 
    @Autowired
    private CoursChangeRepository ccRepository;
    
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        CoursChange taux1 = new CoursChange();
        taux1.setDestination("USD");
        taux1.setSource("EUR");
        taux1.setDate("23/04/2018");
        taux1.setId(2000);
        taux1.setTaux((float)1.03);
        
        ccRepository.save(taux1);
        ccRepository.flush();
     
        // when
        CoursChange cours1 = ccRepository.findBySourceAndDestination(taux1.getSource(), taux1.getDestination());
     
        // then
        assertThat(cours1.getId())
          .isEqualTo(cours1.getId());
    }
 
 
}