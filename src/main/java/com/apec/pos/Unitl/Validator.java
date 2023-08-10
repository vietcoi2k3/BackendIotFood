package com.apec.pos.Unitl;
import java.util.regex.*;

public class Validator {
	 public static boolean validateStudentID(String studentID) {
	        String pattern = "A\\d{5}";
	        return Pattern.matches(pattern, studentID);
	    }

	    public static boolean validatePassword(String password) {
	        String pattern = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$";
	        return Pattern.matches(pattern, password);
	    }
}
