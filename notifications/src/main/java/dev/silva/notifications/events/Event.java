package dev.silva.notifications.events;

import lombok.Data;
import lombok.ToString;

import javax.swing.event.DocumentEvent;
import java.util.Date;

@ToString
@Data
public abstract class Event <T>{

    private String id;
    private Date date;
    private DocumentEvent.EventType type;
    private T data;


}
