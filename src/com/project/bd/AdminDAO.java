package com.project.bd;

import com.project.model.Administrador;

public interface AdminDAO {

	public boolean save(Administrador admin);
	public Administrador getById(int id);
}
