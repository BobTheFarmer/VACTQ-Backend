package com.nighthawk.TypingGameBackendTest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseJpaRepository extends JpaRepository<Phrases, Long> {
    void save(String Phrase);
    List<Phrases> findAllByOrderByPhraseAsc();
    List<Phrases> findByJokeIgnoreCase(String phrase);
}
