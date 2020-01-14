package com.gestion.proforma.app.web.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.gestion.proforma.app.web.models.entities.Empleado;

public interface IEmpleado extends CrudRepository<Empleado, Integer> {
	@Query("SELECT P FROM Empleado P WHERE LOWER(P.apellidos) LIKE CONCAT('%',?1,'%')")
	public List<Empleado> findByApellido(String filtro);
	
	public Empleado findByCedula(String cedula);
	
}
