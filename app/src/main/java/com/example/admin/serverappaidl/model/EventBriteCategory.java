
package com.example.admin.serverappaidl.model;

import java.util.List;

import com.example.admin.serverappaidl.Event;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventBriteCategory {

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
