package de.myrnet.testshow;

import de.myrnet.testshow.domain.EntityHelper;
import de.myrnet.testshow.domain.UserEntity;
import de.myrnet.testshow.domain.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Controller {

    private final UserRepo userRepo;

    @GetMapping("/users")
    public ResponseEntity<Collection<UserEntity>> getUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    @PostMapping(path = "/user/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(@RequestBody UserEntity userToAdd) {
        if (userRepo.findByPrenameAndLastname(userToAdd.getPrename(), userToAdd.getLastname()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        userRepo.saveAndFlush(userToAdd);
        return ResponseEntity.ok("ok");
    }

}
