package com.nighthawk.TypingGameBackendTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phrases")
public class PhrasesAPIController {
    @Autowired
    private PhraseJpaRepository repository;
    @GetMapping("/")
    public ResponseEntity<List<Phrasess>> getPhrasess() {
        // ResponseEntity returns List of Jokes provide by JPA findAll()
        return new ResponseEntity<>( repository.findAll(), HttpStatus.OK);
    }
}
