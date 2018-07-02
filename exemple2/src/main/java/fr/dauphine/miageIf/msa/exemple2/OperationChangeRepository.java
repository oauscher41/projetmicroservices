package fr.dauphine.miageIf.msa.exemple2;

import org.springframework.data.jpa.repository.JpaRepository;

// Creation du JPA Repository basé sur Spring Data
public interface OperationChangeRepository extends JpaRepository<OperationChange, Integer>
{

	OperationChange findByDateAndSourceAndDestination(String date, String source, String destination);
}
