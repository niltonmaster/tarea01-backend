package com.mitocode.service;

import java.util.List;

//CENTRAR TODOAS LAS OPERACIONES DEL PROYECTO.
public interface ICRUD <T,V>{
	
	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	T listarPorId(V id);
	boolean eliminar(V id);
	

}
