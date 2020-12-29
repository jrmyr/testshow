package de.myrnet.testshow.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, String> {

    List<UserEntity> findAll();

    UserEntity findByLastnameOrPrename(String name);

}
