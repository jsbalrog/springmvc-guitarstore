package com.guitarstore.service;

import com.guitarstore.domain.GuitarType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author jenkinset
 */
public class GuitarServiceImplJdbc extends GuitarServiceImpl {
	private DataSource dataSource;

	@Override
	public List<GuitarType> getGuitarTypes() {
		String sql ="SELECT * FROM GUITARTYPES";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<GuitarType> guitarTypes = new ArrayList<GuitarType>();
		List<Map> rows = jdbcTemplate.queryForList(sql);
		for(Map row : rows) {
			GuitarType guitarType = new GuitarType();
			guitarType.setId(((Integer)row.get("ID")).intValue());
			guitarType.setName((String)row.get("NAME"));
			guitarTypes.add(guitarType);
		}
		return guitarTypes;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
