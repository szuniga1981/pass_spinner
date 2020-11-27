package cl.sebastian.generadorpassword.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneratorTest {
//generar el metodo privado
    private Generator generatorTest;
    @Before
       public void setUp() throws Exception {
        generatorTest=new Generator();
    }

    @Test
    public void generatePassword() {
     String result =   generatorTest.generatePassword(10);
     assertEquals(result.length(),10);

    }

}