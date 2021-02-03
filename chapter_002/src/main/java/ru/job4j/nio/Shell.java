package ru.job4j.nio;

public class Shell {

    public String root = "/";
    public String currentDir = root; //текущая директория

    public void cd(String path) {
        String mask = ".*/..";
        if ("/".equals(path)) {
            currentDir = "/";
            pwd();
        } else if ("..".equals(path)) {
            if ("/".equals(currentDir)) {
                pwd();
            } else {
                stepBack();
            }
            pwd();
        } else if (path.matches(mask)) {
           String newPath = path.substring(0, path.length() - 3);
            if (currentDir.equals("/")) {
                currentDir = newPath;
            } else {
                currentDir = currentDir + "/" + newPath;
            }
            stepBack();
        } else {
            if (currentDir.equals("/")) {
                currentDir = currentDir + path;
            } else {
                currentDir = currentDir + "/" + path;
            }
            pwd();
        }
    }

    public void  stepBack() {
        int index = currentDir.lastIndexOf("/");
        if (index == 0) {
            currentDir = "/";
        } else {
            currentDir = currentDir.substring(0, index);
        }
    }

    public String pwd() {
           return currentDir.intern();
    }
}




