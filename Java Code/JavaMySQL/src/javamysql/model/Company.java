/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql.model;

/**
 *
 * @author Nikolas
 */
public class Company {
    
    private static int AFM, telephone, number;
    private static String DOY, name, street, city, country;

    /**
     * @return the AFM
     */
    public int getAFM() {
        return AFM;
    }

    /**
     * @param AFM the AFM to set
     */
    public void setAFM(int AFM) {
        Company.AFM = AFM;
    }

    /**
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        Company.telephone = telephone;
    }

    /**
     * @return the num
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the num to set
     */
    public void setNumber(int number) {
        Company.number = number;
    }

    /**
     * @return the DOY
     */
    public String getDOY() {
        return DOY;
    }

    /**
     * @param DOY the DOY to set
     */
    public void setDOY(String DOY) {
        Company.DOY = DOY;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        Company.name = name;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        Company.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        Company.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        Company.country = country;
    }
    
}
