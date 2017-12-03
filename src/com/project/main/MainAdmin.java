package com.project.main;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.project.bd.AdminDAO;
import com.project.model.Administrador;

public class MainAdmin {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-bean-conf.xml");

		AdminDAO dao = (AdminDAO) ac.getBean("adminDAO");

		Administrador admin = new Administrador("Omar", "admin", new Timestamp(new Date().getTime()));

		try {
			/*
			dao.save(admin);
			System.out.println("Admin guardado en la BD");
			System.out.println(admin);
			*/
			List<Administrador> admins = dao.findAll();
			
			for(Administrador a : admins)
				System.out.println(a);
			
			System.out.println(dao.getById(0));
			
			System.out.println(dao.findByNombre("om").toString());

		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

		((ClassPathXmlApplicationContext) ac).close();
	}
}
