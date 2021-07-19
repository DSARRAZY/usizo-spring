package dyd.usizo.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Need implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @OneToOne
    private Product product;
    private int quantity;
    private boolean founded;

    public Need(Product product) {
        this.product = product;
        quantity = 1;
        founded = false;
    }

    public Need(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        founded = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Need() {
        super();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Need setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public boolean isFounded() {
        return founded;
    }

    public void setFounded(boolean founded) {
        this.founded = founded;
    }
}
