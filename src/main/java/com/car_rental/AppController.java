package com.car_rental;

import com.car_rental.entities.Car;
import com.car_rental.entities.RentalSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 *  Класс представляет из себя Spring MVC контроллер и отвечает за отображение различных элементов и за общую
 *  работу приложения "Информационно-справочная система автопроката".
 */
@Controller
public class AppController {
    /**
     * Сервис для взаимодействия с репозиториями с аннотацией @Autowired для связи.
     */
    @Autowired
    private CarRentalService service;

    /**
     * Отвечает за заполнение данными главной страницы и отображает ее при переходе на главную страницу.
     * @param model Объект модели к которому будут добавлены списки автомобилей и сессий проката.
     * @return Имя представления для отображения.
     */
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Car> listCars = service.listAllCars();
        List<RentalSession> listSessions = service.listAllSessions();
        model.addAttribute("listCars", listCars);
        model.addAttribute("listSessions", listSessions);
        return "index";
    }


    /**
     * Отвечает за отображение страницы "Об авторе" по адресу "/about".
     * @return Имя представления для отображения.
     */
    @RequestMapping("/about")
    public String viewAboutPage(){return "about";}

    /**
     * Отвечает за реализацию поиска автомобиля по критерию и отображает результаты поиска в представлении.
     * @param model Объект модели, к которому будет добавлены списки автомобилей и сессий проката.
     * @param keywordBrand Ключевое слово для поля марки.
     * @param keywordModel Ключевое слово для поля модели.
     * @param keywordGosn Ключевое слово для поля государственного номера.
     * @param keywordProdYear Ключевое слово для поля года производства.
     * @param keywordMileage Ключевое слово для поля пробега.
     * @param keywordIsFree Ключевое слово для поля доступности автомобиля для проката.
     * @return Представление для отображения.
     */
    @RequestMapping("/search_car")
    public String searchCar(Model model, @Param("keywordBrand") String keywordBrand,
                            @Param("keywordModel") String keywordModel,
                            @Param("keywordGosn") String keywordGosn,
                            @Param("keywordProdYear") String keywordProdYear,
                            @Param("keywordMileage") String keywordMileage,
                            @Param("keywordIsFree") String keywordIsFree){
        List<Car> listCarsByCriteria = service.listByCarCriteria(keywordBrand, keywordModel,
                keywordGosn, keywordProdYear, keywordMileage, keywordIsFree);
        List<RentalSession> listAllSessions = service.listAllSessions();
        model.addAttribute("listCars", listCarsByCriteria);
        model.addAttribute("listSessions", listAllSessions);
        model.addAttribute(service.getCarKeywordName(),service.getCarKeyword());
        return "index";
    }

    /**
     * Отвечает за отображение имеющихся праметров автомобиля по идентификатору для их изменения.
     * @param id Идентификатор автомобиля.
     * @return Объект ModelAndView для представления "edit_car".
     */
    @RequestMapping("/edit_car/{id}")
    public ModelAndView showEditCarForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Car car = service.getCar(id);
        mav.addObject("car", car);
        return mav;
    }

    /**
     * Отвечает за отображение формы для добавления нового автомобиля в репозиторий.
     * @param model Объект модели для привязки к нему нвого объекта автомобиля.
     * @return Представление для отображения формы создания нового автомобиля.
     */
    @RequestMapping("/new_car")
    public String showNewCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";
    }

    /**
     * Отвечает за сохранение изменеий в уже существующем автомобиле или для добавления нового и
     * перенаправляет пользователя на главную страницу.
     * @param car Объект автомобиля.
     * @return Представление для отображения главной страницы.
     */
    @RequestMapping(value = "/save_car", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") Car car) {
        service.saveCar(car);
        return "redirect:/";
    }

    /**
     * Отвечает за удаление объекта автомобиля из репозитория по идентификатору и перенаправляет
     * пользователя на главную страницу.
     * @param id Идентификатор автомобиля.
     * @return Представление для отображения главной страницы.
     */
    @RequestMapping("/delete_car/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        service.deleteCar(id);
        return "redirect:/";
    }

    /**
     * Отвечает за реализацию поиска сессии проката по критерию и отображает результаты поиска в представлении.
     * @param model Объект модели, к которому будет добавлены списки автомобилей и сессий проката.
     * @param keywordCarId Ключевое слово для поиска по полю идентификатора автомобиля.
     * @param keywordClientName Ключевое слово для поиска по полю ФИО клиента.
     * @param keywordStartDate Ключевое слово для поиска по полю даты начала проката.
     * @param keywordEndDate Ключевое слово для поиска по полю даты конца проката.
     * @param keywordSessionCost Ключевое слово для поиска по полю цены сессии проката.
     * @return Представление для отображения.
     */
    @RequestMapping("/search_session")
    public String searchSessionByCriteria(Model model,@Param("keywordCarId") String keywordCarId,
                                          @Param("keywordClientName") String keywordClientName,
                                          @Param("keywordStartDate") String keywordStartDate,
                                          @Param("keywordEndDate") String keywordEndDate,
                                          @Param("keywordSessionCost") String keywordSessionCost
                                          ){
        List<RentalSession> listSessionsByCriteria = service.listSessionsByCriteria(keywordCarId, keywordClientName,
                keywordStartDate, keywordEndDate, keywordSessionCost);
        List<Car> listAllCars = service.listAllCars();
        model.addAttribute("listCars", listAllCars);
        model.addAttribute("listSessions", listSessionsByCriteria);
        model.addAttribute(service.getSessionKeywordName(),service.getSessionKeyword());
        return "index";
    }

    /**
     * Отвечает за отображение имеющихся праметров автомобиля по идентификатору для их изменения.
     * @param id Идентификатор сессии проката.
     * @return Объект ModelAndView для представления "edit_session".
     */
    @RequestMapping("/edit_session/{id}")
    public ModelAndView showEditSessionForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_session");
        RentalSession rSession = service.getSession(id);
        mav.addObject("rSession", rSession);
        return mav;
    }

    /**
     * Отвечает за отображение формы для добавления новой сессии проката в репозиторий.
     * @param model Объект модели для привязки к нему нвого объекта сессии проката.
     * @return Представление для отображения формы создания новой сессии проката.
     */
    @RequestMapping("/new_session")
    public String showNewSessionForm(Model model) {
        RentalSession rSession = new RentalSession();
        model.addAttribute("rSession", rSession);
        return "new_session";
    }

    /**
     * Отвечает за сохранение изменеий в уже существующей сессии проката или для добавления новой и
     * перенаправляет пользователя на главную страницу.
     * @param rSession Объект сессии проката.
     * @return Представление для отображения главной страницы.
     */
    @RequestMapping(value = "/save_session", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("rSession") RentalSession rSession) {
        service.saveSession(rSession);
        return "redirect:/";
    }

    /**
     * Отвечает за удаление объекта автомобиля из репозитория по идентификатору и перенаправляет
     * пользователя на главную страницу.
     * @param id Идентификатор сессии проката.
     * @return Представление для отображения главной страницы.
     */
    @RequestMapping("/delete_session/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id) {
        service.deleteSession(id);
        return "redirect:/";
    }

}
