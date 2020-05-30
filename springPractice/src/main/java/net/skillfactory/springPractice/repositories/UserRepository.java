package net.skillfactory.springPractice.repositories;

import net.skillfactory.springPractice.dtos.UserDto;
import net.skillfactory.springPractice.models.User;
import net.skillfactory.springPractice.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<UserProjection> findByDni(String dni);

    Optional<User> getByDni(String dni);

    @Query(value = "select u.name, u.last_name lastName, u.dni, u.age, u.country_code countryCode from users u ;", nativeQuery = true)
    List<UserProjection> findAllUsers();

    @Query(value = "select u.id_user from users u where u.dni = ?1 ;", nativeQuery = true)
    Optional<Integer> getIdByDni(String dni);
}
