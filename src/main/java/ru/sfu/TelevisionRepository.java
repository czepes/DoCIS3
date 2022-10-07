package ru.sfu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.sfu.entity.Television;

import java.util.List;

/**
 * JPA Repository Interface for Television entities
 * @author Agapchenko V.V.
 */
@Component
public interface TelevisionRepository extends JpaRepository<Television, Integer> {
    List<Television> findByWidthAndHeight(
            Integer width,
            Integer height
    );
}
