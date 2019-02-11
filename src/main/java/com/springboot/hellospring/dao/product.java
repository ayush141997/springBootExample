package com.springboot.hellospring.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column(unique=true)
    private String pname;
    @NotNull
    private String type;

    private product() {}

    public product(String pname, String type) {
        this.pname = pname;
        this.type = type;
    }

    /**
     * @return the pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param pname the pname to set
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}