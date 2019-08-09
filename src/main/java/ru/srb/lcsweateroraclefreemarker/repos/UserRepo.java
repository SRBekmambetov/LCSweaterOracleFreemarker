package ru.srb.lcsweateroraclefreemarker.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.srb.lcsweateroraclefreemarker.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
