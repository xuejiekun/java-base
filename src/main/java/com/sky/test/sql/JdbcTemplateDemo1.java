package com.sky.test.sql;

import com.sky.test.domain.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo1 {

    private final static JdbcTemplate template =
            new JdbcTemplate(MyDataSource.getDataSource());

    public static void main(String[] args) {
        insertPerson("啊三", "龙江");
        List<Person> list = queryAllPerson();
        for (Person p: list) {
            System.out.println(p);
        }
    }

    public static List<Person> queryAllPerson(){
        String sql = "SELECT id, name, address FROM person";
        return template.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }

    public static void insertPerson(String name, String address){
        String sql = "INSERT INTO person(name, address) VALUE (?, ?)";
        template.update(sql, name, address);
    }
}
