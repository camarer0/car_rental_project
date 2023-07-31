package com.car_rental.repos;


import com.car_rental.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Даннный интерфейс представляет из себя репозиторий для сущности {@link Car}
 */
public interface CarRepository extends JpaRepository<Car, Long> {
    /**
     * Поиск автомобиля по марке.
     * @param keyword Ключевое слово для поиска по полю марки.
     * @return Список автомобилей, соответствующих ключевому слову поля марки.
     */
    @Query("SELECT p FROM Car p WHERE p.brand LIKE %?1%")
    List<Car> searchByBrand(String keyword);

    /**
     * Поиск автомобиля по модели.
     * @param keyword Ключевое слово для поиска по полю модели.
     * @return Список автомобилей, соответствующих ключевому слову поля модели.
     */
    @Query("SELECT p FROM Car p WHERE p.model LIKE %?1%")
    List<Car> searchByModel(String keyword);

    /**
     * Поис автомобиля по государственному номеру.
     * @param keyword Ключевое слово для поиска по полю государственного номера.
     * @return Список автомобилей, соответствующих ключевому слову поля государственного номера.
     */
    @Query("SELECT p FROM Car p WHERE p.gosn LIKE %?1%")
    List<Car> searchByGosn(String keyword);

    /**
     * Поиск автомобиля по году производства.
     * @param keyword ключевое слово для поиска по полю года производства.
     * @return Список автомобиля, соответствующих ключевому слову поля года производства.
     */
    @Query("SELECT p FROM Car p WHERE CONCAT('',p.prod_year) LIKE %?1%")
    List<Car> searchByProdYear(String keyword);

    /**
     * Поиск автомобиля по пробегу.
     * @param keyword Ключевое слово для поиска по полю пробега.
     * @return Список автомобилей, соответствующих ключевому слову поля пробега.
     */
    @Query("SELECT p FROM Car p WHERE CONCAT('',p.mileage) LIKE %?1%")
    List<Car> searchByMileage(String keyword);

    /**
     * Поиск автомобиля по полю доступности автомобиля для проката.
     * @param keyword Ключевое слово для поиска по полю доступности автомобиля для проката.
     * @return Список автомобилей, соответствующих ключевому слову по полю доступности автомобиля для проката.
     */
    @Query("SELECT p FROM Car p WHERE p.is_free LIKE %?1%")
    List<Car> searchByIsFree(String keyword);
}
