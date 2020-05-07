package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.dto.VentaListaProductoDTO;
import com.mitocode.exception.ModelNotFoundEception;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@GetMapping 
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> lista= service.listar();
		return new ResponseEntity<List<Venta>>(lista,HttpStatus.OK)	;
	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Venta> listarPorId(@PathVariable("id")Integer id){
//		Venta p= service.listarPorId(id);
//		if(p.getIdVenta()==null) {
//			throw new ModelNotFoundEception("ID NO ENTCONTRADO"+id);
//		}
//		return new ResponseEntity<Venta>(p,HttpStatus.OK);
//	}
	

//	@PostMapping
//	public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta venta){
//		Venta p= service.registrar(venta);
//		return new ResponseEntity<Venta>(p,HttpStatus.CREATED);
//	}
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta dto){
		Venta p= service.registrarTransaccional(dto);
		return new ResponseEntity<Venta>(p,HttpStatus.CREATED);
	}
	
//	@PostMapping
//	public ResponseEntity<P> registrar(@Valid @RequestBody Venta venta){
//		Venta p= service.registrar(venta);
//		//localhost:8080/ventas/5
//			//URI location= 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdVenta()).toUri();
//			//return ResponseEntity.created(location).build();
//		return new ResponseEntity<Venta>(p,HttpStatus.CREATED);
//	}
//	
	
	
//	
//	@PutMapping
//	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta){
//		Venta p= service.registrar(venta);
//		return new ResponseEntity<Venta>(p,HttpStatus.CREATED);
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
//		
//		Venta p= service.listarPorId(id);
//		if(p.getIdVenta()==null) {
//			
//			throw new ModelNotFoundEception("ID NO ENTCONTRADO"+id);
//		}
//		service.eliminar(id);
//		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//	}
//	
//	
//	
	

}
