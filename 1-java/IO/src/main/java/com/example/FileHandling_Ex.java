package com.example;

import java.io.*;

public class FileHandling_Ex {

    public static void main(String[] args) {

        File file = new File("/home/nag/dxc-batch4/1-java/IO/Notes.txt");

        // open read stream with file source
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter("/home/nag/dxc-batch4/1-java/IO/Notes_backup.txt",true);
        ) {

//            int c=-1;
//            while((c=fileReader.read())!=-1){
//                System.out.print((char)c);
//            }

            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                fileWriter.write(line + "\n");
            }
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
