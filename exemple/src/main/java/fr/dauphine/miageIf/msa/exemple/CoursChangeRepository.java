package fr.dauphine.miageIf.msa.exemple;


import org.springframework.data.jpa.repository.JpaRepository;
// Creation du JPA Repository basé sur Spring Data
public interface CoursChangeRepository extends JpaRepository<CoursChange, Integer>
{
	
	CoursChange findBySourceAndDestination(String source, String destination);
	
}
