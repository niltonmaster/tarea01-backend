package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;
import com.mitocode.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;
	
	@Override
	public Persona registrar(Persona obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Persona modificar(Persona obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Persona> op= repo.findById(id);
		return op.isPresent() ? op.get() : new Persona();
		//return repo.findById(id).orElse(other);
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true;
	}

}
