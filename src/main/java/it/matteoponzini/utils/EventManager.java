package it.matteoponzini.utils;

import java.util.*;
//TODO: javadoc
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String ... eventType) {
        if(eventType == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        for (String event : eventType) {
            this.listeners.put(event, new ArrayList<EventListener>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        if(eventType == null || listener == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
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
        if(eventType == null || listener == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(listeners.containsKey(eventType)) {
            List<EventListener> events = listeners.get(eventType);
            events.remove(listener);
        }else{
            throw new NullPointerException("Element not exist");
        }
    }

    public void notify(String eventType, Object object) {
        if(eventType == null || object == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(listeners.containsKey(eventType)){
            List<EventListener> users = listeners.get(eventType);
            for (EventListener listener : users) {
                System.out.println(listener.notify(eventType, object));
            }
        }else{
            throw new NullPointerException("Element not exist");
        }
    }

    public Map<String, List<EventListener>> getListeners() {
        return listeners;
    }

    public void setListeners(Map<String, List<EventListener>> listeners) {
        this.listeners = listeners;
    }
}
