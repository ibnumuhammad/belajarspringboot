/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajarspringboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Home
 */
public class databaseconfig {

    @Autowired
    private DataSource datasource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(this.datasource);
    }
}
