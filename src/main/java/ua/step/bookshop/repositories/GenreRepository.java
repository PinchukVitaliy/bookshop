package ua.step.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.step.bookshop.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Short>{

}
