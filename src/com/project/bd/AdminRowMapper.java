package com.project.bd;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.model.Administrador;

public class AdminRowMapper implements RowMapper<Administrador> {

	@Override
	public Administrador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Administrador admin = new Administrador();
		admin.setIdAd(rs.getInt("idAd"));
		admin.setNombre(rs.getString("nombre"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		return admin;
	}

}
