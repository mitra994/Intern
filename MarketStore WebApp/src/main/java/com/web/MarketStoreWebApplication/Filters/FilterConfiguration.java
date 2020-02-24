package com.web.MarketStoreWebApplication.Filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration{

    @Autowired
    private BasicFilter basicFilter;

    @Bean
    public FilterRegistrationBean<BasicFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<BasicFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(basicFilter);
        filterFilterRegistrationBean.addUrlPatterns("/customer/*");

        return filterFilterRegistrationBean;
    }

}
