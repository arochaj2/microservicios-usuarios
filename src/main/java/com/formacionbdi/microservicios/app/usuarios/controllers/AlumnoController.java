package com.formacionbdi.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicios.app.usuarios.services.AlumnoService;
import com.formacionbdi.microservicios.commons.controllers.CommonController;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
		
		
		Optional<Alumno> o = service.findById(id);
		
		if (o.isEmpty()) {
			
			return ResponseEntity.notFound().build(); // HTTP STATUS 404
		}
		
		Alumno alumnodb= o.get();
		alumnodb.setNombre(alumno.getNombre());
		alumnodb.setApellido(alumno.getApellido());
		alumnodb.setEmail(alumno.getEmail());
		
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnodb)); // HTTP STATUS 201 
		
		
	}
	
	
	
	

}
