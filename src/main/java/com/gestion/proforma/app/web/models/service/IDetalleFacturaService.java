package com.gestion.proforma.app.web.models.service;

import java.util.List;
import com.gestion.proforma.app.web.models.entities.DetalleFactura;

public interface IDetalleFacturaService {
	public void save(DetalleFactura detalleProforma);
	public DetalleFactura findById(Integer id);
	public void delete(Integer id);
	public List<DetalleFactura> findAll();

}
