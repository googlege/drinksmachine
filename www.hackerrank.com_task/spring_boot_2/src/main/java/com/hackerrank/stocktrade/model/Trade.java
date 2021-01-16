package com.hackerrank.stocktrade.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//String json = "{\"id\": 1, \"type\": \"buy\", \"user\": {\"id\": 2, \"name\": \"Amy Palmer\"}, \"symbol\": \"AA\", \"shares\": 11, \"price\": 174.82, \"timestamp\": \"2018-12-28 13:18:48\"}";
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.DEFAULT, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonPropertyOrder({ "id", "type", "user", "symbol", "shares", "price", "timestamp" })

@Entity
@Access(AccessType.FIELD)
@Table(name = Trade.TABLE_NAME)
public class Trade implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "t_trade";

    
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty(value = "type", access = JsonProperty.Access.READ_WRITE)
    @Column(name = "type", length = 256)
    private String type;
    
    @JsonProperty(value = "user", access = JsonProperty.Access.READ_WRITE)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade= {CascadeType.REFRESH})
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
    
    @JsonProperty(value = "symbol", access = JsonProperty.Access.READ_WRITE)
    @Column(name = "symbol", length = 256)
    private String symbol;
    
    @JsonProperty(value = "shares", access = JsonProperty.Access.READ_WRITE)
    @Column(name = "shares")
    private Integer shares;
    
    @JsonProperty(value = "price", access = JsonProperty.Access.READ_WRITE)
    @Column(name = "price")
    private Float price;
    
    @JsonProperty(value = "timestamp", access = JsonProperty.Access.READ_WRITE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "tradingtime")
    private LocalDateTime timestamp;
    
    public Trade() {
    }
    
    public Trade(Long id, String type, User user, String symbol, Integer quantity, Float price, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public Integer getShares() {
        return this.shares;
    }
    
    public void setShares(Integer shares) {
        this.shares = shares;
    }
    
    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
