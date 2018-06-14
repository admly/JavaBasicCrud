package com.studbaza.baza.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

@Component
public class EventDaoImpl implements EventDao{
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String content, Date date, String placeOfOccurence, String hour) {
        String SQL = "insert into event (content, date, placeOfOccurence, hour) values (?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, content, date, placeOfOccurence, hour);

    }

    @Override
    public Event getEvent() {
        String SQL = "select * from event";
        Event event = jdbcTemplateObject.queryForObject(SQL, new EventMapper());
        return event;
    }

    @Override
    public List<Event> listEvents() {
        String SQL = "select * from event";
        List<Event> events = jdbcTemplateObject.query(SQL, new EventMapper());
        return events;
    }

    @Override
    public void delete(Long id) {
        String SQL = "delete from event where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted, id=" + id);

    }

    @Override
    public void update(Long id, String content) {
        String SQL = "update event set content = ? where id = ?";
        jdbcTemplateObject.update(SQL, content, id);
    }

    @Override
    public List<Event> getEventByPlaceOfOccurence(String placeOfOccurence) {
        String SQL = "select * from event where placeOfOccurence = ?";
        List<Event> events = jdbcTemplateObject.query(SQL, new EventMapper(), placeOfOccurence);
        return events;
    }
}
