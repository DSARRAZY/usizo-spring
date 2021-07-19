package dyd.usizo.models;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Product extends DataBaseObject implements Serializable {

    private String type;

    public Product(int id, String nom, String imgUrl, String type) {
        super(id,nom,imgUrl);
        this.type = type;
    }

    public Product(String nom, String imgUrl, String type) {
        super(nom,imgUrl);
        this.type = type;
    }

    public Product() {
        super();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

