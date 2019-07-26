package com.sc.reporte.almacen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.reporte.almacen.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findByName(String role);
	
}
