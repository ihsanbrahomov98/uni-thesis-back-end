package com.arjuncodes.studentsystem.model.ProductModel;

import com.arjuncodes.studentsystem.model.ReviewModel.Review;
import com.arjuncodes.studentsystem.model.SearchModel.Search;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sitter")
public class Sitter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surName;
    private String image;

    private String description;
    private String email;
    private String telephone;
    private String address;

    private String city;
    private String housingSize;
//    //TODO
//    private List<String> reviews;
//        //TODO
   private String startingDate;
    private String  endingDate;
    @Column(columnDefinition = "TEXT")
    private String takenDates;
    private String rating;
    private String password;
    private String role;
    private int price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sitter", cascade = CascadeType.ALL)
    private List<Search> jobs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sitter", cascade = CascadeType.ALL)
    private List<Review> review = new ArrayList<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public List<Search> getJobs() {
        return jobs;
    }

    public void setJobs(List<Search> jobs) {
        this.jobs = jobs;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTakenDates() {

        return takenDates;
    }

    public void setTakenDates(String takenDates) {
        this.takenDates = takenDates;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getHousingSize() {
        return housingSize;
    }

    public void setHousingSize(String housingSize) {
        this.housingSize = housingSize;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }
    //    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public HashMap<String, String> getPets() {
//        return pets;
//    }
//
//    public void setPets(HashMap<String, String> pets) {
//        this.pets = pets;
//    }
//
//    public HashMap<String, String> getHousingSize() {
//        return housingSize;
//    }
//
//    public void setHousingSize(HashMap<String, String> housingSize) {
//        this.housingSize = housingSize;
//    }
//
//    public List<String> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<String> reviews) {
//        this.reviews = reviews;
//    }
//
//    public List<String> getTakenDates() {
//        return takenDates;
//    }
//
//    public void setTakenDates(List<String> takenDates) {
//        this.takenDates = takenDates;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }


    public Sitter() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
