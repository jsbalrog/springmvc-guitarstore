package com.guitarstore.domain;

/**
 *
 * @author etjenkins
 */
public class GuitarSearchCriteria {
    private String query;

    public GuitarSearchCriteria() { }

    public GuitarSearchCriteria(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }


}
