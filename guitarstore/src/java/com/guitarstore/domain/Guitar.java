package com.guitarstore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author etjenkins
 */
@Entity
@Table(name = "GUITARS")
public class Guitar implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
    private Integer id;

	@Column(name = "BRAND")
    private String brand;

	@Column(name = "MODEL")
    private String model;

	@Column(name = "YEAR_MADE")
    private String year;

	@Column(name = "PRICE")
    private Float price;

	@ManyToOne
	@JoinColumn(name = "GUITARTYPE_ID")
    private GuitarType guitarType;

	@Column(name = "IMAGE")
	private byte[] guitarImage;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public GuitarType getGuitarType() {
	return guitarType;
    }

    public void setGuitarType(GuitarType guitarType) {
	this.guitarType = guitarType;
    }

	public byte[] getGuitarImage() {
		return guitarImage;
	}

	public void setGuitarImage(byte[] guitarImage) {
		this.guitarImage = guitarImage;
	}
}