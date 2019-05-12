package ua.step.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.bookshop.models.Publish;

public interface PublisherRepository extends JpaRepository<Publish, Short>{

}
