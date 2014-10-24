package com.guitarstore.service;

import com.guitarstore.domain.Guitar;
import com.guitarstore.domain.GuitarSearchCriteria;
import com.guitarstore.domain.GuitarType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etjenkins
 */
public class GuitarServiceImpl implements GuitarService {
    private List<Guitar> guitars;
	private List<GuitarType> guitarTypes;

	@Override
    public List<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }

	@Override
    public List<GuitarType> getGuitarTypes() {
        return guitarTypes;
    }

	public void setGuitarTypes(List<GuitarType> guitarTypes) {
		this.guitarTypes = guitarTypes;
	}

	@Override
    public List<Guitar> findGuitars(GuitarSearchCriteria guitarSearchCriteria) {
        List<Guitar> results = new ArrayList<Guitar>();
        for(Guitar g : guitars) {
            if(g.getBrand().equalsIgnoreCase(guitarSearchCriteria.getQuery()) ||
                    g.getModel().equalsIgnoreCase(guitarSearchCriteria.getQuery())) {
                results.add(g);
            }
        }
        return results;
    }

	@Override
    public Guitar getGuitar(int id) {
        for(Guitar g : guitars) {
            if(g.getId() == id) {
                return g;
            }
        }
        return null;
    }

	@Override
	public void create(Guitar guitar) {
		guitars.add(guitar);
	}

	@Override
	public void deleteGuitar(int id) {
		Guitar g = getGuitar(id);
		guitars.remove(g);
	}

	@Override
	public GuitarType getGuitarType(int guitarTypeId) {
		for(GuitarType gt : guitarTypes) {
			if(gt.getId() == guitarTypeId) {
				return gt;
			}
		}
		return null;
	}

	@Override
	public void update(Guitar guitar) {
		Guitar g = getGuitar(guitar.getId());
		guitars.remove(g);
		guitars.add(guitar);
	}

}