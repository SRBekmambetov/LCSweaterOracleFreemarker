package ru.srb.lcsweateroraclefreemarker.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.srb.lcsweateroraclefreemarker.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
