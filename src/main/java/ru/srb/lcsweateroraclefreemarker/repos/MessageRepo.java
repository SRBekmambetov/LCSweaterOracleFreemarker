package ru.srb.lcsweateroraclefreemarker.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.srb.lcsweateroraclefreemarker.domain.Message;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findByTag(String tag);

}
