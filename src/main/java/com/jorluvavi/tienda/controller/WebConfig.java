/*
Clase para manejar varios idiomas
*/
package com.jorluvavi.tienda.controller;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author jorge
 */
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("en")); //Idioma por defecto
        return slr;
    }
    
    //Cambiar automaticamente el idioma
    @Bean
    public LocaleChangeInterceptor localeChangerInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    public void addInterceptor(InterceptorRegistry registro){
        registro.addInterceptor(localeChangerInterceptor());        
    }
    
//    @Override
//    public void addViewControllers(ViewControllerRegistry registro){
//     registro.addViewController("/").setViewName("index");
//     registro.addViewController("/login");
//    }
}
