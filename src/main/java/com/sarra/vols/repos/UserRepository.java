package com.sarra.vols.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sarra.vols.entities.User;
public interface UserRepository extends JpaRepository <User, Long> {
	User findByUsername(String username);
}
