package fr.dauphine.miageIf.msa.exemple;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoursChange
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@Column(nullable = false)
    private String source;
	@Column(nullable = false)
    private String destination;
	@Column(nullable = false)
    private float taux;
	@Column(nullable = false)
    private String date;

    public int getId()
    {
        return id;
    }

    public String getSource()
    {
        return source;
    }

    public String getDestination()
    {
        return destination;
    }
    
    public float getTaux()
    {
    	return taux;
    }
    public String getDate()
    {
    	return date;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setSource(String deviseSource)
    {
        this.source = deviseSource;
    }

    public void setDestination(String deviseDestination)
    {
        this.destination = deviseDestination;
    }
    public void setTaux(float taux)
    {
        this.taux = taux;
    }
    public void setDate(String date)
    {
    	this.date = date;
    }
    public void creer(String dSrc, String dDest, double taux, Date dateC)
    {
    	
    }
    
    public void modifier(String dSrc, String dDest, double taux, Date dateC)
    {
    
    }

    public CoursChange recuperer(String dSrc, String dDest, Date dateC)
    {
    	CoursChange cc;
    	
    	return cc;
    }
    
    public void supprimer(String dSrc, String dDest, Date dateC)
    {
    	
    }
    
    public CoursChange()
    {
    }


    
}