package ui.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService  {
    private static final String numberPattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
   private static final String emailPattern = "^(.+)@(.+)$";
   private static final String alphabetPattern = "[a-zA-Z]+";
   private static final String salaryPattern = "(?!0+(?:\\\\.0+)?$)[0-9]+(?:\\\\.[0-9]+)?";


    public boolean isEmailValid(List<String> emails) {
        Pattern pattern = Pattern.compile(emailPattern);
        boolean isValid = false;
        if (!emails.isEmpty()) {
            for (String value : emails) {
                isValid = true;
                Matcher matcher = pattern.matcher(value);
                if (!matcher.matches()) {
                    isValid = false;
                    System.out.println(value+" is invalid email");
                }
            }
        }
        return isValid;
    }


    public boolean isAlphabetValid(List<String> elements) {
        boolean isAlphabetValid = elements.stream().allMatch(el->el.matches(alphabetPattern));
        //uncomment to see incorrect name/surname
        //elements.stream().filter(el->!el.matches("[a-zA-Z]+")).forEach(System.out::println);
        return isAlphabetValid;
    }

    public boolean isPhoneValid(List<String> numbers){
        boolean isPhoneValid = numbers.stream().allMatch(el->el.matches(numberPattern));
        //uncomment to see incorrect numbers
       // numbers.stream().filter(el->!el.matches(numberPattern)).forEach(System.out::println);
        return isPhoneValid;
    }
    public boolean isSalaryValid(List<String> salaries){
        boolean isSalaryValid = salaries.stream().allMatch(el->el.matches(salaryPattern));
        return isSalaryValid;
    }



}
