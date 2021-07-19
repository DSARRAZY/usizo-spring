package dyd.usizo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DataBaseObject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String nom;
    private String imgUrl;

    public DataBaseObject(int id, String nom, String imgUrl) {
        this.id = id;
        this.nom = nom;
        this.imgUrl = imgUrl;
    }

    public DataBaseObject() {

    }

    public DataBaseObject(String nom, String imgUrl) {
        this.nom = nom;
        this.imgUrl = imgUrl;
    }

    public DataBaseObject(String nom) {
        this.nom = nom;
        this.imgUrl = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
