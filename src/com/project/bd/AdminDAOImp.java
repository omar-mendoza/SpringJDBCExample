package com.project.bd;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.project.model.Administrador;

@Component("adminDAO")
public class AdminDAOImp implements AdminDAO {

	NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Administrador admin) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("cargo", admin.getCargo());
		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		return jdbc.
				update("insert into administrador (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
	}

	@Override
	public Administrador getById(int id) {
		
		String sql ="select * from administrador where idAd = :id"; 
		return null;
	}
	

}
