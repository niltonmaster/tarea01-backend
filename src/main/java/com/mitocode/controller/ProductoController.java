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

import com.mitocode.exception.ModelNotFoundEception;

import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping 
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> lista= service.listar();
		return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK)	;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id")Integer id){
		Producto p= service.listarPorId(id);
		if(p.getIdProducto()==null) {
			
			throw new ModelNotFoundEception("ID NO ENTCONTRADO"+id);
		}
		return new ResponseEntity<Producto>(p,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto){
		Producto p= service.registrar(producto);
		return new ResponseEntity<Producto>(p,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto){
		Producto p= service.registrar(producto);
		return new ResponseEntity<Producto>(p,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Producto p= service.listarPorId(id);
		if(p.getIdProducto()==null) {
			
			throw new ModelNotFoundEception("ID NO ENCONTRADO"+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	

}
