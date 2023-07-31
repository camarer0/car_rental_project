package com.car_rental;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация MVC для приложения "Информационно-справочная система автопроката".
 * Реализует интерфейс WebMvcConfigurer для настройки представлений.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    /**
     * Регистрирует контроллеры представлений.
     * @param registry Реестр контроллеров представлений.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }
}
