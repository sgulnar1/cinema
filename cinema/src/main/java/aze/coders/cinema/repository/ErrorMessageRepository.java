package aze.coders.cinema.repository;

import aze.coders.cinema.entity.ErrorMessage;
import aze.coders.cinema.enums.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Integer> {
    Optional<ErrorMessage> findByErrorCode(ErrorCode errorCode);
}
