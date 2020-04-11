package com.yhmpc.movie.domain.jpa;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author yhm
 * @Date 4/11/2020 14:13
 */
@Entity
@Table(name = "t_movie")
public class MovieDb {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(length = 36)
    private String id;

    private Integer rank;

    @Column(name = "first_title")
    private String firstTitle;

    @Column(name = "second_title")
    private String secondTitle;

    private Date year;

    private String country;

    private String type;

    private Double score;

    private Long votes;

    private String quote;

    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "MovieDb{" +
                "id='" + id + '\'' +
                ", rank=" + rank +
                ", firstTitle='" + firstTitle + '\'' +
                ", secondTitle='" + secondTitle + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", score=" + score +
                ", votes=" + votes +
                ", quote='" + quote + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}