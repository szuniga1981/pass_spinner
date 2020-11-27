package cl.sebastian.generadorpassword.model;

import java.util.Random;

public class Generator {
    //3. Generar Genrator
//se cambia void a string por el testing que etsmaos realizando
    public String generatePassword(int targetStringLength ) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'


        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
return generatedString;


    }

}

