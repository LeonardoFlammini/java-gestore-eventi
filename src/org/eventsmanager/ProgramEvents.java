package org.eventsmanager;

import org.eventsmanager.comparator.EventDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgramEvents {
    private String title;
    private ArrayList<Event> eventsArray;

    public ProgramEvents(String title){
        this.title = title;
        this.eventsArray = new ArrayList<>();
    }

    public void addEvent(Event e){
        eventsArray.add(e);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : eventsArray) {
            if (event.getDate().equals(date)) {
                eventsOnDate.add(event);
            }
        }
        return eventsOnDate;
    }

    public int getLength(){
        return eventsArray.size();
    }

    public void toEmptyList(){
        eventsArray.clear();
    }

    public void sortEventsByDate() {
        eventsArray.sort(new EventDateComparator());
    }

    public String getSortedEventsString() {
        sortEventsByDate();

        StringBuilder sb = new StringBuilder();
        sb.append("Programma: ").append(title).append("\n");
        for (Event event : eventsArray) {
            sb.append("○ ").append(event.getDate()).append(" - ").append(event.getTitle()).append("\n");
        }
        return sb.toString();
    }

}
