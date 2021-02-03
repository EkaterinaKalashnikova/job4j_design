package ru.job4j.nio;

import java.io.File;

public class ShellFolder {
    public String directory = "/";
    public String currentDir = directory; //текущая директория


    public void cd(String path) {
        int index = path.indexOf(" ");
        if (index == -1) {
            pwd(directory);
        } else {
            String newPath = path.substring(index).trim();
            pwd(newPath);
        }
    }



    public String pwd(String s) {
        //String pwd = new File("/").getAbsolutePath();
        //pwd = pwd.substring(0, pwd.length() - 2);
        return currentDir.intern();
        //return pwd;
    }
}
