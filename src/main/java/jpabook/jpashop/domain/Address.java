package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(length = 10) // 길이 제한 공통으로 관리되는 것이 좋다
    private String city;
    @Column(length = 20)
    private String street;
    @Column(length = 5)
    private String zipcode;

    // 객체지향적으로 값을 의미있게 쓸 수 있다
    public String fullAddress() {
        return getCity() + " " + getStreet() + " " + getZipcode();
    }

    public boolean isValid() {
        return true;
    }

    public String getCity() {
        return city;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
        return getZipcode() != null ? getZipcode().equals(address.getZipcode()) : address.getZipcode() == null;
    }

    @Override
    public int hashCode() {
        int result = getCity() != null ? getCity().hashCode() : 0;
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getZipcode() != null ? getZipcode().hashCode() : 0);
        return result;
    }
}
