package com.car_rental.repos;

import com.car_rental.entities.RentalSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * Даннный интерфейс представляет из себя репозиторий для сущности {@link RentalSession}
 */
public interface RentalSessionRepository extends JpaRepository<RentalSession, Long> {
    /**
     * Поиск сессии проката по идентификатору автомобиля.
     * @param keyword Ключевое слово для поиска сессии проката по полю идентификатора автомобиля.
     * @return Список сессий проката, соответствующих ключевому слову по полю идентификатора автомобиля.
     */
    @Query("SELECT p FROM RentalSession p WHERE concat('',p.car_id) LIKE %?1%")
    List<RentalSession> searchByCarId(String keyword);

    /**
     * Поиск сессий проката по ФИО клиента.
     * @param keyword Ключевое слово для поиска сессий проката по полю ФИО клиента.
     * @return Список сессий проката, соответствующих ключевому слову по полю ФИО клиента.
     */
    @Query("SELECT p FROM RentalSession p WHERE p.client_name LIKE %?1%")
    List<RentalSession> searchByClientName(String keyword);

    /**
     * Поиск сессий проката по дате и времени начала сессии проката.
     * @param keyword Ключевое слово для поиска по полю даты и времени начала сессии проката.
     * @return Список сессий проката, соответствующих ключевому слову по полю даты и времени начала сессии проката.
     */
    @Query("SELECT p FROM RentalSession p WHERE concat('',p.start_date) LIKE %?1%")
    List<RentalSession> searchByStartDate(String keyword);
    /**
     * Поиск сессий проката по дате и времени конца сессии проката.
     * @param keyword Ключевое слово для поиска по полю даты и времени конца сессии проката.
     * @return Список сессий проката, соответствующих ключевому слову по полю даты и времени конца сессии проката.
     */
    @Query("SELECT p FROM RentalSession p WHERE concat('',p.end_date) LIKE %?1%")
    List<RentalSession> searchByEndDate(String keyword);

    /**
     * Поиск сессий проката по цене.
     * @param keyword Ключевое слово для поиска по полю цены сессии проката.
     * @return Список сессий проката, соответствующих ключевому слову по полю цены сессии проката.
     */
    @Query("SELECT p FROM RentalSession p WHERE concat('',p.cost) LIKE %?1%")
    List<RentalSession> searchByCost(String keyword);
}
