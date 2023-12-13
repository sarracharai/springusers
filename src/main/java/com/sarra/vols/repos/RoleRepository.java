package com.sarra.vols.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sarra.vols.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRole(String role);

}
