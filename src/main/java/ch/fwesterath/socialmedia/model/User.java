package ch.fwesterath.socialmedia.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "FROM User")
public class User {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private UserAdress adress;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAdress getAdress() {
        return adress;
    }

    public void setAdress(UserAdress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
