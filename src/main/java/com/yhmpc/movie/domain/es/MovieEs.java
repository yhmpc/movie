package com.yhmpc.movie.domain.es;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Author yhm
 * @Date 4/11/2020 14:13
 */
@Document(indexName = "movie", type = "_doc", shards = 1, replicas = 0)
public class MovieEs {
    @Id
    private String id;

    @Field(store = true, type = FieldType.Integer)
    private Integer rank;

    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String firstTitle;

    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String secondTitle;

    @Field(store = true, type = FieldType.Date)
    private Date year;

    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String country;

    @Field(store = true, type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String type;

    @Field(store = true, type = FieldType.Double)
    private Double score;

    @Field(store = true, type = FieldType.Long)
    private Long votes;

    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String quote;

    @Field(index = false, store = true, type = FieldType.Keyword)
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

}