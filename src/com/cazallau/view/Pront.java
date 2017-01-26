package com.cazallau.view;

import com.cazallau.model.Contact;

import java.util.Scanner;

/**
 * Created by gemabeltran on 26/1/17.
 */
public class Pront {
    //Read line
    public static String read() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
    //Print the program title
    public static void printTitle(){
        System.out.println("Welcome to contacts!");

    }
    //Print the line to enter the command
    public static void print(int i){
        System.out.print("(" + i + ")>");

    }
    //Prints the lines to add a contact and return the contact to add
    public static Contact printAddContact() {

        System.out.print("> Name: ");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.print("> Phone: ");

        Scanner scanner1 = new Scanner(System.in);
        String phone = scanner.nextLine();

        Contact contact= new Contact();

        contact.setName(name);
        contact.setPhone(phone);

        return contact ;

    }
    //Prints the lines to delete a contact and return the position of the contact to delete
    public static int printDeleteContact(){
        System.out.print("Introduzca la posicion del contacto > ");

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        int position = Integer.parseInt(line);

        return position;
    }
    //Print program help
    public static void printHelp(){
        System.out.println("Add (A)- Añadir un contatcto \n" +
                "Delete (D)- Borra un contacto \n" +
                "List (L)- Lista de todos los contactos \n" +
                "Quit (Q)- Finalizar el programa \n" +
                "Help (H)- Ayuda");
    }



}

