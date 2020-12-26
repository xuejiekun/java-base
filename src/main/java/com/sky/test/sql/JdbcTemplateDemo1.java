package com.sky.test.sql;

import com.sky.test.domain.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(MyDataSource.getDataSource());
        System.out.println(template);

        String sql;
//        sql = "INSERT INTO person(name, address) VALUE (?, ?);";
//        int res = template.update(sql, "xiaogui", "guangzhou");
//        System.out.printf("res:%d\n", res);

        sql = "SELECT id, name, address FROM person";
        List<Person> list = template.query(sql, new BeanPropertyRowMapper<>(Person.class));
        for (Person p: list) {
            System.out.println(p);
        }
    }
}
