package com.studbaza.baza.model;

import com.studbaza.baza.utils.HoursValidatorConstraint;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.util.Date;

@Component
public class Event {

    @Size(min=10, max= 300, message = "Opis powinien mieć od 10 do 300 znaków!")
    private String content;

    @Size(max=30, message = "Miejsce zdarzenia powinno mieć od 0 do 30 znaków")
    private String placeOfOccurence;

    private Date date;

    @HoursValidatorConstraint
    private String hour;

    @Override
    public String toString(){
        return String.format("Event content=%s",content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlaceOfOccurence() {
        return placeOfOccurence;
    }

    public void setPlaceOfOccurence(String placeOfOccurence) {
        this.placeOfOccurence = placeOfOccurence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
