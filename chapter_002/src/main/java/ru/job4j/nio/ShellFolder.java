package ru.job4j.nio;

import java.io.File;
import java.util.LinkedList;

public class ShellFolder {
    public String root = "/";
    public LinkedList<String> currentDir = new LinkedList<>();

    public void cd(String path) {
        if (currentDir.isEmpty()) {
            currentDir.add(root);
        }

        String mask = ".*/..";
        if ("/".equals(path)) {
            while (currentDir.size() > 0) {
                currentDir.remove(currentDir.size() - 1);
            }
                currentDir.add(root);
            pwd();
        } else if ("..".equals(path)) {
            if (currentDir.size() == 1) {
                pwd();
            } else {
                stepBack();
            }
            pwd();
        } else if (path.matches(mask)) {
            String newPath = path.substring(0, path.length() - 3);
            if (currentDir.size() == 1) {
                currentDir.add(newPath);

            } else if (currentDir.size() > 1) {
                currentDir.add("/");
                currentDir.add(newPath);
            }
            stepBack();
        } else {
            switch (currentDir.size()) {
                case 1:
                    currentDir.add(path);
                    break;
                default:
                    currentDir.add("/");
                    currentDir.add(path);
                    break;
            }
           pwd();
        }
    }

    public void  stepBack() {
        if (currentDir.size() > 1) {
            currentDir.remove(currentDir.size() - 1);
        }
    }

    public String pwd() {
        StringBuilder curDir = new StringBuilder();
        for (int i = 0; i < currentDir.size(); i++) {
            curDir.append(currentDir.get(i));
        }
        return curDir.toString();
    }
}

// / user / local