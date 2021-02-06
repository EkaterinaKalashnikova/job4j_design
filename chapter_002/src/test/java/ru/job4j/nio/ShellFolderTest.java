package ru.job4j.nio;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShellFolderTest {
    @Test
    public void whenCdBack()  {
        ShellFolder shellFolder = new ShellFolder();
        shellFolder.cd("/user/..");
        assertThat(
                shellFolder.pwd(), is("/")
        );
    }

    @Test
    public void whenCdRoot()  {
        ShellFolder shellFolder = new ShellFolder();
        shellFolder.cd("/");
        assertThat(
                shellFolder.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal()  {
        ShellFolder shellFolder = new ShellFolder();
        shellFolder.cd("user");
        shellFolder.cd("local");
        assertThat(
                shellFolder.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack()  {
        ShellFolder shellFolder = new ShellFolder();
        shellFolder.cd("user");
        shellFolder.cd("..");
        assertThat(
                shellFolder.pwd(), is("/")
        );
    }
}