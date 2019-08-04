package com.sugarbox.jellyframeworktools.poi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class CreateFile {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String osname = System.getProperty("os.name", "").toLowerCase();
        if (osname.startsWith("windows")) {
            String text = "Hello world Windows";
            try {
                File file = new File("C:/example.txt");
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                output.write(text);
                output.close();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        } else if (osname.startsWith("linux")) {
            String text = "Hello world Linux";
            try {
                File file = new File("/home/mask/IdeaProjects/sugarbox/jelly-framework-tools/srcexample.txt");
                BufferedWriter output = new BufferedWriter(new FileWriter(file));
                output.write(text);
                output.close();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Sorry, your operating system is different");
        }
    }
}