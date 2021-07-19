package dyd.usizo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ShoppingList implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany
    private Collection<User> members;
    @OneToMany
    private Collection<Need> needList;

    public ShoppingList(User member) {
        this.members = new ArrayList<>();
        name = member.getNom() + "'s List";
        members.add(member);
        needList = new ArrayList<>();
    }

    public ShoppingList() {
        super();
    }

    public Collection<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public Collection<Need> getNeedList() {
        return needList;
    }

    public void setNeedList(List<Need> needList) {
        this.needList = needList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
