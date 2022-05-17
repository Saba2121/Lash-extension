package pl.saba.lashextension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static Boolean isValidNameOrSurname(String string) {
        return validate("[a-zA-Z]{2}+", string);

    }

    public static Boolean isValidPhoneNumber(String string) {
        return validate("^\\d{9}$", string);

    }

    private static Boolean validate(String regex, String string) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();

    }
}

//"^[+][0-9]{10,13}$"   +48500123456
//^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{3}$   123-456-789
///\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{3})/



