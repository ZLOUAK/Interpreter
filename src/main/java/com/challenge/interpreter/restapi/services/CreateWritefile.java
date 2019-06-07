package com.challenge.interpreter.restapi.services;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class CreateWritefile {

    public static void Createfile(String code) throws IOException {
        String Path="/home/Devloper/Public/Interpreter/python.py";
        File file = new File(Path);
        //Create the file
        if (file.exists()) {
            System.out.println("File already exists.");
            file.delete();
            file.createNewFile();
            System.out.println("File is created!");
        } else {
            file.createNewFile();
            System.out.println("File is created!");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("import sys \n");
        writer.write(code);
        writer.close();
    }

    public static void Createtemfile(String code, String temp) throws IOException {
        String Path="/home/Devloper/Public/Interpreter/pythontem.py";
        File file = new File(Path);
        //Create the file
        if (file.exists()) {
            System.out.println("Variable File already exists");
            file.delete();
            file.createNewFile();
            System.out.println("Variable File is created!");
        } else {
            file.createNewFile();
            System.out.println("File is created!");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("import sys \n");
        writer.write(temp +"\n");
        writer.write(code);
        writer.close();
    }
}

