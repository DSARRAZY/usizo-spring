package dyd.usizo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "public")
public class User extends DataBaseObject implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "password", length = 64)
    private String password;

    public User(String username, String password,Role role) {
        super(username,"/images/user.png");
        this.password = password;
        this.role = role;
        this.shoppingLists = new ArrayList<>();
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany
    private Collection<ShoppingList> shoppingLists;

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(Collection<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}