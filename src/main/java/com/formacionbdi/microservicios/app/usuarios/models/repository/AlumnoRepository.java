package com.formacionbdi.microservicios.app.usuarios.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacionbdi.microservicios.commons.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {
	
	/*el upper y el concat se usa para que en la
	 * busqueda omita mayusculas y minusculas
	 * */
	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%',?1,'%')) or upper(a.apellido) like upper(concat('%',?1,'%'))")
	public List<Alumno> findByNombreOrApellido(String term);
	
	


}
