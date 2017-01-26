package com.cazallau.controller;

import com.cazallau.managers.CommandParser;
import com.cazallau.managers.ContactsFile;
import com.cazallau.model.Command;
import com.cazallau.model.Contact;
import com.cazallau.model.ContactsDiary;
import com.cazallau.view.Pront;

import java.io.File;
import java.io.IOException;

/**
 * Created by gemabeltran on 26/1/17.
 */
public class StarDiary {

    public static void startDiary() throws IOException {
        File file = new File("ContactsDiary");
        ContactsDiary contactsDiary = new ContactsDiary();
        if (file.exists()) {
            contactsDiary.setContactsDiary(ContactsFile.readFile(file));
        }


        boolean end = false;
        Pront.printTitle();

        while (end != true) {
            Pront.print(contactsDiary.getContactsDiary().size());

            String command = Pront.read();
            Command com = CommandParser.parse(command);

            switch (com) {
                case ADD:
                    Contact contact = Pront.printAddContact();
                    if (contact.getName().equals("") || contact.getPhone().equals("")) {
                        System.out.println("Contacto no guardado. Debe introducir el nombre y el telefono");
                    } else {
                        contactsDiary.addContac(contact);
                        System.out.println("Contacto guardado.");
                    }
                    break;
                case LIST:
                    for (int i = 0; i < contactsDiary.getContactsDiary().size(); i++) {
                        Contact c = contactsDiary.getContact(i);
                        System.out.println(i + " - " + c.getName() + " - " + c.getPhone());
                    }
                    break;

                case DELETE:
                    int position = Pront.printDeleteContact();
                    if (position < 0 || position > contactsDiary.getContactsDiary().size() - 1) {
                        System.out.println("No hay contactos en esa posicion");
                    } else {
                        contactsDiary.deleteContact(position);
                        System.out.println("Contacto borrado");
                    }
                    break;

                case HELP:
                    Pront.printHelp();
                    break;

                case QUIT:
                    file = new File("ContactsDiary");
                    ContactsFile.createFile(file, contactsDiary.getContactsDiary());
                    end = true;
                    break;
                case UNKNOW:
                    System.out.println("Comando desconocido. Pulse (h) para ver la ayuda");

            }

        }

    }
}
