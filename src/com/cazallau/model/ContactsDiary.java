package com.cazallau.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemabeltran on 25/1/17.
 */
public class ContactsDiary {

    private List<Contact> contactsDiary = new ArrayList<>();

    public ContactsDiary() {

    }

    public List<Contact> getContactsDiary() {
        return contactsDiary;
    }

    public void setContactsDiary(List<Contact> contactsDiary) {
        this.contactsDiary = contactsDiary;
    }
    public void addContac(Contact contact){
        contactsDiary.add(contact);
    }
    public Contact getContact(int position){
        return contactsDiary.get(position);
    }
    public void deleteContact(int position){
        contactsDiary.remove(position);
    }
}
