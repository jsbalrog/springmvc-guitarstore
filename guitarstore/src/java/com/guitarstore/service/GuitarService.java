/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.guitarstore.service;

import com.guitarstore.domain.Guitar;
import com.guitarstore.domain.GuitarSearchCriteria;
import com.guitarstore.domain.GuitarType;
import java.util.List;

/**
 *
 * @author etjenkins
 */
public interface GuitarService {
    public List<Guitar> getGuitars();

    public List<Guitar> findGuitars(GuitarSearchCriteria guitarSearchCriteria);

    public Guitar getGuitar(int id);

	public void create(Guitar guitar);

	public void deleteGuitar(int id);

	public List<GuitarType> getGuitarTypes();

	public GuitarType getGuitarType(int guitarTypeId);

	public void update(Guitar guitar);
}
