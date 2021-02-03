package ru.job4j.nio;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ShellTest {
    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd("/user/..");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd("/");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocalBack() {
        Shell shell = new Shell();
        shell.cd("user/local");
        shell.cd("..");
        assertThat(
                shell.pwd(), is("/user")
        );
    }
}