package com.project.bd;

import java.util.List;

import com.project.model.Administrador;

public interface AdminDAO {

	public boolean save(Administrador admin);
	public Administrador getById(int id);
	public List<Administrador> findAll();
	public List<Administrador> findByNombre(String nombre);
}
