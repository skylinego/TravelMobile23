package models;

import play.data.format.*;
import play.data.validation.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.Collection;

/**
 * POI entity managed by JPA
 */
@Entity
public class POI {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;
    
    @Constraints.Required
    public String name;

    public String description;

    public String city;

    public String state;

    public String zip;

    public String country;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn (name="countryID")
    public Country countryID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn (name="continentID")
    public Continent continentID;

    public Float latitude;

    public Float longitude;

    public int isCustomized;

    public Float rank;

    @Column (name="createdAt")
    private java.sql.Timestamp createdAt;

    @Column (name="updatedAt")
    private java.sql.Timestamp updatedAt;
    
    /**
     * Find a POI by id.
     */
    public static POI findById(Long id) {
        return JPA.em().find(POI.class, id);
    }

    /**
     * Find a POI by id.
     */
    public static Collection<POI> findByCity(String queryInfo) {
        Query query = JPA.em().createQuery("SELECT e FROM POI e where e.city =:cityName")
                .setParameter("cityName", queryInfo)
                .setMaxResults(10);
        return (Collection<POI>) query.getResultList();
    }
    
    /**
     * Update this computer.
     */
    public void update(Long id) {
       /* if(this.company.id == null) {
            this.company = null;
        } else {
            this.company = Company.findById(company.id);
        }
        this.id = id;
        JPA.em().merge(this);*/
    }
    
    /**
     * Insert this new POI.
     */
    public void save() {
       /* if(this.c.id == null) {
            this.company = null;
        } else {
            this.company = Company.findById(company.id);
        }
        JPA.em().persist(this);*/
    }
    
    /**
     * Delete this POI.
     */
    public void delete() {
        JPA.em().remove(this);
    }

    /**
     * Delete this POI.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id is " + this.id + " ");
        sb.append("name is " + this.name + " ");
        sb.append("lat is " + this.latitude + " ");
        sb.append("long is " + this.longitude + " ");
        return sb.toString();
    }
    
}

