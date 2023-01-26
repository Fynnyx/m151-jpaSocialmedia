package ch.fwesterath.socialmedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "adress")
@NamedQuery(name = "Adress.findAll", query = "FROM UserAdress")
public class UserAdress {
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private long id;

        @Column(name = "street")
        private String street;

        @Column(name = "city")
        private String city;

        @Column(name = "zip")
        private int zip;

        @Column(name = "country")
        private String country;

        @OneToOne(mappedBy = "adress")
        @JsonIgnore
        private User user;

        public UserAdress() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getZip() {
            return zip;
        }

        public void setZip(int zip) {
            this.zip = zip;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
}
