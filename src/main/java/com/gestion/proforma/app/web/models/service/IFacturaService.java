package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.Factura;

public interface IFacturaService {
	public void save(Factura factura);
	public Factura findById(Integer id);
	public void delete(Integer id);
	public List<Factura> findAll();
}
