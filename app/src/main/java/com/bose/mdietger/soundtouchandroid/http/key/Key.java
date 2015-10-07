package com.bose.mdietger.soundtouchandroid.http.key;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Keys are used as a simple means to interact with the SoundTouch speaker.
 */
@Root
public class Key {

    public static final String SENDER = "Gabbo";

    @Attribute(name = "state")
    private String state;

    @Text
    private String value;

    @Attribute(name = "sender")
    private String sender;

    public Key(){}

    public Key(String state, String sender, String value){
        this.state = state;
        this.value = value;
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}