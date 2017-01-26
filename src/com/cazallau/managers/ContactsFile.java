package com.cazallau.managers;

import com.cazallau.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gemabeltran on 26/1/17.
 */
public class ContactsFile {
    private File file1 = new File("aa");

    public static void createFile(File file, List<Contact> arrData) throws IOException {

            FileWriter writer = new FileWriter(file);

            int size = arrData.size();

            for (int i = 0; i <size ; i++) {
                String str1 = arrData.get(i).getName().toString();
                String str2 = arrData.get(i).getPhone().toString();
                writer.write(str1 + "\n");

                writer.write(str2);
                if (i<size -1){
                    writer.write("\n");
                }
            }

            writer.close();
    }

    public static List<Contact> readFile (File fileName){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Contact> contacts = new ArrayList<Contact>();
        String line = null;
        try {
            Contact contact = new Contact();
            int x = 0;
            while ((line = bufferedReader.readLine()) != null){

                if (x==0){
                    contact.setName(line);
                    x = x+1;
                }
                else {
                    contact.setPhone(line);
                    contacts.add(contact);
                    contact = new Contact();
                    x=0;
                }

            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return contacts;
    }

}


