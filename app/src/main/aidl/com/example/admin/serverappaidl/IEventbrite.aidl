// IEventbrite.aidl
package com.example.admin.serverappaidl;
import java.util.List;
import com.example.admin.serverappaidl.Event;

// Declare any non-default types here with import statements

interface IEventbrite {

    int getPid();
    List<Event> getEvents();

}

