package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@Ignore
public class GeneratorTest {


    @Test(expected = IllegalArgumentException.class)
    public void produceKeyNotCard() {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("name", "Ekaterina");
        valueMap.put("subject", "you");
        String valueSpecifics =  "I am a Ekaterina, Who are you?";
        Generator generator = new GeneratorSpecifics();
        String result = generator.produce(valueSpecifics, valueMap);
        assertThat(result, is("Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceExtraKeys() {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("name", "Ekaterina");
        String valueSpecifics =  "I am a Ekaterina, Who are you?";
        Generator generator = new GeneratorSpecifics();
        String result = generator.produce(valueSpecifics, valueMap);
        assertThat(result, is("I am a Ekaterina"));
    }
}