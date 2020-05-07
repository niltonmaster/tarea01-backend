package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.VentaListaProductoDTO;
import com.mitocode.model.Producto;
import com.mitocode.model.Venta;
import com.mitocode.repo.IDetalleVenta;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Autowired
	private IDetalleVenta dvrepo;

	@Transactional
	@Override
	public Venta registrarTransaccional(Venta dto) {

		// TODO Auto-generated method stub

		dto.getDetalleVenta().forEach(det->{
			det.setVenta(dto);
			det.getProducto().setIdProducto(det.getProducto().getIdProducto());//puta linea
		});
		
		repo.save(dto);
		
		return dto;
	}

	@Override
	public Venta modificar(Venta obj) {
		return repo.save(obj);
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Venta listarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Venta> op= repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	//	return new Venta();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

	@Override
	public Venta registrar(Venta obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
