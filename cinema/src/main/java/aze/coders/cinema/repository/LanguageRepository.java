package aze.coders.cinema.repository;

import aze.coders.cinema.entity.Language;
import aze.coders.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
