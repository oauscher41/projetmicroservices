package fr.dauphine.miageIf.msa.exemple2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import fr.dauphine.miageIf.msa.exemple.CoursChange;

@Entity
public class OperationChange
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@Column(nullable = false)
    private String date;
	@Column(nullable = false)
    private float montant;

    public int getIdTransaction()
    {
        return id;
    }

   public String getDate()
    {
        return date;
    }
   

    public float getMontant()
    {
        return montant;
    }
    
    public void setIdTransaction(int idTransaction)
    {
        this.id = idTransaction;
    }

    public void setDate(String date)
    {
        this.date = date;
    }


    public void setMontant(float montant)
    {
        this.montant = montant;
    }
    
    public void creer(float montant)
    {
    	
    }
    
    public void modifier(int id, int montant)
    {
    	
    }

    public OperationChange recuperer(int idTransaction)
    {
    	
    	return OperationChange;
    }
    
    public void supprimer(int id)
    {
    	
    }

    public OperationChange()
    {
    }


    
}