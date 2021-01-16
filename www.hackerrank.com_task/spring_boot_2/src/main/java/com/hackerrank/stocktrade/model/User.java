package com.hackerrank.stocktrade.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.DEFAULT, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonPropertyOrder({ "id", "name" })

@Entity
@Access(AccessType.FIELD)
@Table(name = User.TABLE_NAME)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "t_user";

   
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    @Column(name = "name", length = 256)
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<Trade> tradeList;
    
    
    public User() {
    }
    
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    
    public List<Trade> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

	public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
