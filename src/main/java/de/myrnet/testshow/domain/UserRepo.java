package de.myrnet.testshow.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, String> {

    @Override
    List<UserEntity> findAll();

    Optional<UserEntity> findByPrenameAndLastname(String prename, String lastname);

    @Override
    UserEntity saveAndFlush(UserEntity entity);

}
