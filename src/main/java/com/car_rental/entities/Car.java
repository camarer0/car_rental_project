package com.car_rental.entities;

import jakarta.persistence.*;

/**
 * Класс, представляющий из себя сущность автомобиля.
 */
@Entity
@Table(name = "Car")
public class Car {
    /**
     * Идентификатор автомобиля.
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * Марка автомобиля.
     */
    @Column(name = "brand")
    private String brand;
    /**
     * Модель автомобиля.
     */
    @Column(name = "model")
    private String model;
    /**
     * Государственный номер автомобиля.
     */
    @Column(name = "gosn")
    private String gosn;
    /**
     * Год производства автомобиля.
     */
    @Column(name = "prod_year")
    private int prod_year;
    /**
     * Пробег автомобиля.
     */
    @Column(name = "mileage")
    private int mileage;
    /**
     * Доступность автомобиля для проката.
     */
    @Column(name = "is_free")
    private String is_free;

    /**
     * Стандартный конструктор класса.
     */
    public Car(){}

    /**
     * Получить идентификатор автомобиля.
     * @return идентификатор автомобиля.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return this.id;
    }

    /**
     * Установить идентификатор автомобиля.
     * @param id идентификатор автомобиля.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Получить марку автомобиля.
     * @return Марка автомобиля.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Установить марку автомобиля.
     * @param brand Марка автомобиля.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Получить модель автомобиля.
     * @return Модель автомобиля.
     */
    public String getModel() {
        return model;
    }

    /**
     * Установить модель автомобиля.
     * @param model модель автомобиля.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Получить государственный номер автгомобиля.
     * @return Государственный номер автомобиля.
     */
    public String getGosn() {
        return gosn;
    }

    /**
     * Установить государственный номер автомобиля.
     * @param gosn Государственный номер автомобиля.
     */
    public void setGosn(String gosn) {
        this.gosn = gosn;
    }

    /**
     * Получить год производства автомобиляю
     * @return Год производства автомобиля.
     */
    public int getProd_year() {
        return prod_year;
    }

    /**
     * Получить год производства автомобиля.
     * @param prod_year Год производства автомобиля.
     */
    public void setProd_year(int prod_year) {
        this.prod_year = prod_year;
    }

    /**
     * Получить пробег автомобиля.
     * @return Пробег автомобиля.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Установить пробег автомобиля.
     * @param mileage Пробег автомобиля.
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    /**
     * Получить доступность автомобиля для проката.
     * @return доступность автомобиля для проката.
     */
    public String getIs_free() {
        return is_free;
    }

    /**
     * Установить доступность автомобиля для проката.
     * @param is_free
     */
    public void setIs_free(String is_free) {
        this.is_free = is_free;
    }
}
