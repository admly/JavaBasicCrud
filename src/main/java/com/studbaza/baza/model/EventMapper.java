package com.studbaza.baza.model;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {


    @Nullable
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setContent(rs.getString("content"));
        event.setDate(rs.getDate("date"));
        event.setPlaceOfOccurence(rs.getString("placeOfOccurence"));
        event.setHour(rs.getString("hour"));
        return event;
    }
}
