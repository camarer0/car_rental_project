package com.car_rental.entities;

import jakarta.persistence.*;

/**
 * Класс, представляющий из себя сущность сессии проката.
 */
@Entity
@Table(name = "Session")
public class RentalSession {
    /**
     * Идентификатор сессии проката.
     */
    @Id
    @Column(name = "id")
    private Long id;
    /**
     * Идентификатор автомобиля.
     */
    @Column(name = "car_id")
    private Long car_id;
    /**
     * ФИО клиента.
     */
    @Column(name = "client_name")
    private String client_name;
    /**
     * Дата и время начала проката.
     */
    @Column(name = "start_date")
    private String start_date;
    /**
     * Дата и время конца проката.
     */
    @Column(name = "end_date")
    private String end_date;
    /**
     * Цена сессии проката.
     */
    @Column(name = "cost")
    private float cost;

    /**
     * Стандартный конструктор класса.
     */
    public RentalSession(){}

    /**\
     * Получить идентификатор сессии проката.
     * @return идентификатор сессии проката.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return this.id;
    }

    /**
     * Установить идентификатор сессии проката.
     * @param id Идентификатор сессии проката.
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Получить идентификатор автомобиля.
     * @return Идентификатор автомобиля.
     */
    public Long getCar_id() {
        return car_id;
    }

    /**
     * Установить идентификатор автомобиля.
     * @param car_id Идентификатор автомобиля.
     */
    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    /**
     * Получить ФИО клиента.
     * @return ФИО клиента.
     */
    public String getClient_name() {
        return client_name;
    }

    /**
     * Установить ФИО клиента.
     * @param client_name ФИО клиента.
     */
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    /**
     * Получить дату и время начала проката.
     * @return Дата и время начала проката
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * Установить дату и время начала проката.
     * @param start_date Дата и время начала проката.
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * Получить дату и время конца проката.
     * @return Дата и время конца проката.
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * Установить дату и время конца проката.
     * @param end_date Дата и время конца проката.
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    /**
     * Получить цену сессии проката.
     * @return Цена сессии проката.
     */
    public float getCost() {
        return cost;
    }

    /**
     * Установить цену стоимости проката.
     * @param cost Цена стоимости проката.
     */
    public void setCost(float cost) {
        this.cost = cost;
    }
}
