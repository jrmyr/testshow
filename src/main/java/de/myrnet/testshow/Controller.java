package de.myrnet.testshow;

import de.myrnet.testshow.domain.UserEntity;
import de.myrnet.testshow.domain.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity greeting(@RequestBody UserEntity user) {
        return ResponseEntity.ok(null);
    }

}
