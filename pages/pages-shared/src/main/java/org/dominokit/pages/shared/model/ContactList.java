package org.dominokit.pages.shared.model;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class ContactList {

    public static final ContactList_MapperImpl MAPPER= new ContactList_MapperImpl();

    private List<Contact> contacts;

    public ContactList() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
