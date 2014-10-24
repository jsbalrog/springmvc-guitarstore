package com.guitarstore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jenkinset
 */
@Entity
@Table(name = "GUITARTYPES")
public class GuitarType implements Serializable {

	@Id
	@Column(name = "GUITARTYPE_ID")
    private Integer id;

	@Column(name = "NAME")
    private String name;

    public GuitarType() { }

    public GuitarType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	// In order to make sure the right GuitarType was selected for a guitar 
	// on an edit, not only did I have to override equals, I had to do this
	// ugly workaround, because it appears that equals() is getting called
	// twice for each value--the first time, object is the ID, the second time,
	// object is the actual GuitarType object.
	@Override
	public boolean equals(Object o) {
		if(o instanceof GuitarType) {
			return this.getId().equals( ((GuitarType)o).getId() );
		} else if (o instanceof Integer) {
			return this.getId().equals((Integer)o);
		}
		return false;
	}
}
