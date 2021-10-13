package dev.tobycook.demo.models.views;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "sales", name = "vindividualcustomer")
public class IndividualCustomerView {

    @Id
    @Column(name = "businessentityid")
    private Integer businessentityid;

    @Column(name = "title")
    private String title;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "phonenumbertype")
    private String phonenumbertype;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "emailpromotion")
    private Integer emailpromotion;

    @Column(name = "addresstype")
    private String addresstype;

    @Column(name = "addressline1")
    private String addressline1;

    @Column(name = "addressline2")
    private String addressline2;

    @Column(name = "city")
    private String city;

    @Column(name = "stateprovincename")
    private String stateprovincename;

    @Column(name = "postalcode")
    private String postalcode;

    @Column(name = "countryregionname")
    private String countryregionname;

    public Integer getBusinessentityid() {
        return this.businessentityid;
    }

    public void setBusinessentityid(Integer businessentityid) {
        this.businessentityid = businessentityid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return this.middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPhonenumber() {
        return this.phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumbertype() {
        return this.phonenumbertype;
    }

    public void setPhonenumbertype(String phonenumbertype) {
        this.phonenumbertype = phonenumbertype;
    }

    public String getEmailaddress() {
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public Integer getEmailpromotion() {
        return this.emailpromotion;
    }

    public void setEmailpromotion(Integer emailpromotion) {
        this.emailpromotion = emailpromotion;
    }

    public String getAddresstype() {
        return this.addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public String getAddressline1() {
        return this.addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return this.addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateprovincename() {
        return this.stateprovincename;
    }

    public void setStateprovincename(String stateprovincename) {
        this.stateprovincename = stateprovincename;
    }

    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountryregionname() {
        return this.countryregionname;
    }

    public void setCountryregionname(String countryregionname) {
        this.countryregionname = countryregionname;
    }
}
