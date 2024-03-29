package com.obl3oppg1;

public class Validator {

    public static final String ANY_LETTER = "[A-Za-zÆØÅæøå]";
    public static final String ANY_LETTER_OR_DIGIT = "[A-Za-zÆØÅæøå\\d]";
    public static final String THREE_OR_MORE_TIMES = "{3,}";

    /**
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     *
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene, og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isGyldigUsername(String username) {

        if (username == null) {
            return false;
        }
        return username.matches("^[a-zA-Z0-9_.-]$");
    }
}
