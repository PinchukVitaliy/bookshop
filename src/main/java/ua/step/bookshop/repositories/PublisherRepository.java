package ua.step.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ua.step.bookshop.models.Publish;

@Repository
public interface PublisherRepository extends JpaRepository<Publish, Short>{

}
