package com.val.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("prototype")
public class Event {
    static final AtomicInteger integer = new AtomicInteger(0);
    final int id;
    String msg;
    EventType type;
    @Value("#{new java.util.Date()}") Date date;
    @Value("#{T(java.text.DateFormat).getDateTimeInstance()}") DateFormat dateFormat;

    public Event() {
        id = integer.getAndIncrement();
    }

    public Event(Date date, DateFormat dateFormat) {
        this();
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public Event(String msg, EventType type, Date date, DateFormat dateFormat) {
        this();
        this.msg = msg;
        this.type = type;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", type=" + type +
                ", date=" + dateFormat.format(date) +
                '}';
    }

}
