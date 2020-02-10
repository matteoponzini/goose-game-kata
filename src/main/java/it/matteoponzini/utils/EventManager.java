package it.matteoponzini.utils;

import java.util.*;
//TODO: javadoc
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String ... eventType) {
        for (String event : eventType) {
            this.listeners.put(event, new ArrayList<EventListener>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        if(listeners.containsKey(eventType)){
            List<EventListener> events = listeners.get(eventType);
            events.add(listener);
        }else{
            List<EventListener> events = new ArrayList<>();
            events.add(listener);
            this.listeners.put(eventType, events);
        }
    }

    public void unsubscribe(String eventType, EventListener listener) {
        if(listeners.containsKey(eventType)) {
            List<EventListener> events = listeners.get(eventType);
            events.remove(listener);
        }else{
            //TODO:eccezzione non esiste
        }
    }

    public void notify(String eventType, Object object) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            System.out.println(listener.notify(eventType, object));
        }
    }
}
