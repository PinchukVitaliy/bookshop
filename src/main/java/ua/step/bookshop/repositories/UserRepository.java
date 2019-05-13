package ua.step.bookshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.step.bookshop.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Short> {
}
