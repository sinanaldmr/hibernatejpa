package com.hibernatejpa.model;

import com.hibernatejpa.model.util.PhoneType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@NamedQueries({
        @NamedQuery(name = "UserDetail.findByUsername",query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.user u WHERE u.username=:username"),
        @NamedQuery(name = "UserDetail.findWithAddressByUsername",query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.adresses WHERE ud.user.username=:username"),
        @NamedQuery(name = "UserDetail.findWithAdvertisementByUsername",query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.advertisements WHERE ud.user.username=:username")

})
public class UserDetail implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userDetailId;
    private String firstName;
    private String lastName;
    private Date birthOfDate;

    @ElementCollection
    @JoinTable(name = "userdetail_phonenumber", joinColumns = @JoinColumn(name = "userDetailId"))
    @MapKeyColumn(name = "phoneType")
    @Column(name = "phoneNumber")
    private Map<PhoneType,String> phoneNumbers=new HashMap<PhoneType,String >();

    @ElementCollection(fetch = FetchType.LAZY)
    @JoinTable(name = "userdetail_address",joinColumns = @JoinColumn(name = "userDetailId"))
    private List<Adress> adresses=new ArrayList<Adress>();

    @OneToMany(mappedBy = "userDetail",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<Advertisement> advertisements=new ArrayList<Advertisement>();

    @OneToOne(mappedBy = "userDetail",fetch = FetchType.LAZY)
    private User user;

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Date birthOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
    }

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "userDetailId=" + userDetailId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthOfDate=" + birthOfDate +
                ", phoneNumbers=" + phoneNumbers +
                ", adresses=" + adresses +
                ", advertisements=" + advertisements +
                ", user=" + user +
                '}';
    }
}
