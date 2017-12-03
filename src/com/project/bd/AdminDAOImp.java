package com.project.bd;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

		
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("nombre", admin.getNombre());
//		paramMap.addValue("cargo", admin.getCargo());
//		paramMap.addValue("fechaCreacion", admin.getFechaCreacion());
		
		// Esto y lo anterior es lo mismo
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		
		return jdbc.
				update("insert into administrador (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
	}

	@Override
	public Administrador getById(int id) {
		String sql ="select * from administrador where idAd = :id"; 

		// return (Administrador) jdbc.query(sql, new MapSqlParameterSource("id", id), new AdminRowMapper()).get(0);
		return jdbc.queryForObject(sql, new MapSqlParameterSource("id", id), new AdminRowMapper());
	}
	
	@Override
	public List<Administrador> findAll() {
		return jdbc.query("select * from Administrador", new AdminRowMapper());
	}

	@Override
	public List<Administrador> findByNombre(String nombre) {
		String sql ="select * from Administrador a where a.nombre like :nombre"; 
		// return (Administrador) jdbc.query(sql, new MapSqlParameterSource("id", id), new AdminRowMapper()).get(0);
		return jdbc.query(sql, new MapSqlParameterSource("nombre", "%"+nombre+"%"), new AdminRowMapper());
	}
	

}
