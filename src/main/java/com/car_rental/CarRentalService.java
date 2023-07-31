package com.car_rental;

import com.car_rental.entities.Car;
import com.car_rental.entities.RentalSession;
import com.car_rental.repos.CarRepository;
import com.car_rental.repos.RentalSessionRepository;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс сервиса, отвечающий за манипуляцию с данными автомобилей и сессий проката.
 */
@Service
public class CarRentalService {
    /**
     * Репозиторий автомобилей.
     */
    @Autowired
    CarRepository carRepo;
    /**
     * Репозиторий сессий проката.
     */
    @Autowired
    RentalSessionRepository sessionRepo;
    /**
     * Название ключевого слова для поиска автомобиля.
     */
    private String carKeywordName;
    /**
     * Ключевое слово для поиска автомобиля.
     */
    private String carKeyword;
    /**
     * Название ключевого слова для поиска сессии проката.
     */
    private String sessionKeywordName;
    /**
     * Ключевое слово для поиска сессии проката.
     */
    private String sessionKeyword;

    /**
     * Получить ключевое слово для поиска автомобиля.
     * @return Ключевое слово для поиска автомобиля.
     */
    public String getCarKeyword() {
        return carKeyword;
    }

    /**
     * Получить названия ключевого слова для поиска автомобиля.
     * @return Название ключевого слова для поиска автомобиля.
     */
    public String getCarKeywordName(){
        return carKeywordName;
    }
    /**
     * Получить ключевое слово для поиска сессии проката.
     * @return Ключевое слово для поиска сессии проката.
     */
    public String getSessionKeyword() {
        return sessionKeyword;
    }
    /**
     * Получить названия ключевого слова для поиска сессии проката.
     * @return Название ключевого слова для поиска сессии проката.
     */
    public String getSessionKeywordName() {
        return sessionKeywordName;
    }

    /**
     * Возвращает список всех автомобилей, хранящихся в репозитории.
     * @return Список всех автомобилей.
     */
    public List<Car> listAllCars(){
        return carRepo.findAll();
    }

    /**
     * Возвращает список автомобилей, соответствующих определенному критерию.
     * @param keywordBrand Ключевое слово для поиска по полю марки.
     * @param keywordModel Ключевое слово для поиска по полю модели.
     * @param keywordGosn Ключевое слово для поиска по полю государственного номера.
     * @param keywordProdYear Ключевое слово для поиска по полю года производства.
     * @param keywordMileage Ключевое слово для поиска по полю пробега.
     * @param keywordIsFree Ключевое слово для поиска по полю доступности автомобиля для проката.
     * @return Список автомобилей, соответствующих одному из критериев.
     */
    public List<Car> listByCarCriteria(String keywordBrand, String keywordModel,
                                       String keywordGosn, String keywordProdYear,
                                       String keywordMileage, String keywordIsFree){
        if (!StringUtil.isNullOrEmpty(keywordBrand)){
            this.carKeywordName = "keywordBrand";
            this.carKeyword = keywordBrand;
            return carRepo.searchByBrand(keywordBrand);
        }
        else if (!StringUtil.isNullOrEmpty(keywordModel)){
            this.carKeywordName = "keywordModel";
            this.carKeyword = keywordModel;
            return carRepo.searchByModel(keywordModel);
        }
        else if (!StringUtil.isNullOrEmpty(keywordGosn)){
            this.carKeywordName = "keywordGosn";
            this.carKeyword = keywordGosn;
            return carRepo.searchByGosn(keywordGosn);
        }
        else if (!StringUtil.isNullOrEmpty(keywordProdYear)){
            this.carKeywordName = "keywordProdYear";
            this.carKeyword = keywordProdYear;
            return carRepo.searchByProdYear(keywordProdYear);
        }
        else if (!StringUtil.isNullOrEmpty(keywordMileage)){
            this.carKeywordName = "keywordMileage";
            this.carKeyword = keywordMileage;
            return carRepo.searchByMileage(keywordMileage);
        }
        else if (!StringUtil.isNullOrEmpty(keywordIsFree)){
            this.carKeywordName = "keywordIsFree";
            this.carKeyword = keywordIsFree;
            return carRepo.searchByIsFree(keywordIsFree);
        }
        else return carRepo.findAll();
    }

    /**
     * Сохранение автомобиля в репозитории.
     * @param car Объект автомобиля.
     */
    public void saveCar(Car car) {
        carRepo.save(car);
    }

    /**
     * Получение автомобиля по идентификатору.
     * @param id Идентификатор автомобиля.
     * @return Объект автомобиля.
     */
    public Car getCar(Long id) {
        return carRepo.findById(id).get();
    }

    /**
     * Удаление автомобиля из репозитория.
     * @param id Идентификатор автомобиля.
     */
    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }

    /**
     * Возвращает список всех сессий проката, хранящихся в репозитории.
     * @return Список всех сессий проката.
     */
    public List<RentalSession> listAllSessions(){
        return sessionRepo.findAll();
    }

    /**
     * Возвращает список сессий проката, соответствующих определенному критерию.
     * @param keywordCarId Ключевое слово для поиска по полю идентификатора автомобиля.
     * @param keywordClientName Ключевое слово для поиска по полю ФИО клиента.
     * @param keywordStartDate Ключевое слово для поиска по полю даты и времени начала проката.
     * @param keywordEndDate Ключевое слово для поиска по полю даты и времени конца проката.
     * @param keywordSessionCost Ключевое слово для поиска по полю цены сессии проката.
     * @return Список сессий проката, соответствующих одному из критериев.
     */
    public List<RentalSession> listSessionsByCriteria(String keywordCarId, String keywordClientName,
                                                     String keywordStartDate, String keywordEndDate,
                                                     String keywordSessionCost){
        if (!StringUtil.isNullOrEmpty(keywordCarId)){
            this.sessionKeywordName = "keywordCarId";
            this.sessionKeyword = keywordCarId;
            return sessionRepo.searchByCarId(keywordCarId);
        }
        else if (!StringUtil.isNullOrEmpty(keywordClientName)){
            this.sessionKeywordName = "keywordClientName";
            this.sessionKeyword = keywordClientName;
            return sessionRepo.searchByClientName(keywordClientName);
        }
        else if (!StringUtil.isNullOrEmpty(keywordStartDate)){
            this.sessionKeywordName = "keywordStartDate";
            this.sessionKeyword = keywordStartDate;
            return sessionRepo.searchByStartDate(keywordStartDate);
        }
        else if (!StringUtil.isNullOrEmpty(keywordEndDate)){
            this.sessionKeywordName = "keywordEndDate";
            this.sessionKeyword = keywordEndDate;
            return sessionRepo.searchByEndDate(keywordEndDate);
        }
        else if (!StringUtil.isNullOrEmpty(keywordSessionCost)){
            this.sessionKeywordName = "keywordSessionCost";
            this.sessionKeyword = keywordSessionCost;
            return sessionRepo.searchByCost(keywordSessionCost);
        }
        else return sessionRepo.findAll();
    }

    /**
     * Сохранение сессии проката в репозитории.
     * @param session Объект сессии проката.
     */
    public void saveSession(RentalSession session) {
        sessionRepo.save(session);
    }

    /**
     * Возвращает сессию проката по идентификатору.
     * @param id Идентификатор сессии проката.
     * @return Объект сессии проката.
     */
    public RentalSession getSession(Long id) {
        return sessionRepo.findById(id).get();
    }

    /**
     * Удаление сесси проката из репозитория.
     * @param id Идентификатор сессии проката.
     */
    public void deleteSession(Long id) {sessionRepo.deleteById(id);}
}
