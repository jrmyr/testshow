package de.myrnet.testshow;

import de.myrnet.testshow.domain.UserEntity;
import de.myrnet.testshow.domain.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Controller {

    private final UserRepo userRepo;

    @GetMapping("/users")
    public ResponseEntity<Collection<UserEntity>> getUsers() {

        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/user")
    public ResponseEntity<Collection<UserEntity>> greeting(
            @RequestParam(value = "lastname", defaultValue = "World") String name) {
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return ResponseEntity.ok(null);
    }

}
