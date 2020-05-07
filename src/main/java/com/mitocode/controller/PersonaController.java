package com.mitocode.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModelNotFoundEception;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	
	@Autowired
	private IPersonaService service;
	
	@GetMapping 
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista= service.listar();
		return new ResponseEntity<List<Persona>>(lista,HttpStatus.OK)	;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id")Integer id){
		Persona p= service.listarPorId(id);
		if(p.getIdPersona()==null) {
			
			throw new ModelNotFoundEception("ID NO ENTCONTRADO"+id);
		}
		return new ResponseEntity<Persona>(p,HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona){
		Persona p= service.registrar(persona);
		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);
	}
	
//	@PostMapping
//	public ResponseEntity<P> registrar(@Valid @RequestBody Persona persona){
//		Persona p= service.registrar(persona);
//		//localhost:8080/personas/5
//			//URI location= 	ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPersona()).toUri();
//			//return ResponseEntity.created(location).build();
//		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);
//	}
//	
	
	
	
	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona){
		Persona p= service.registrar(persona);
		return new ResponseEntity<Persona>(p,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		
		Persona p= service.listarPorId(id);
		if(p.getIdPersona()==null) {
			
			throw new ModelNotFoundEception("ID NO ENTCONTRADO"+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
