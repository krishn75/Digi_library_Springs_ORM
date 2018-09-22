package com.app.Validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Users;

@Component
public class Validator_cls implements Validator {

	@Override
	public boolean supports(Class<?> clz) {
		/*if (Users.class.equals(clz)) {
			return true;
		} else {
			return false;
		}*/
		return Users.class.equals(clz);

	}

	@Override
	public void validate(Object ob, Errors errors) {
		Users u = (Users) ob;
		if (!Pattern.compile("[a-zA-Z]{2,15}").matcher(u.getUsername()).matches()) {
			errors.rejectValue("username", null, "only alphabets are allowed");
		}
		if (!Pattern.compile("[a-zA-Z@.0-9]{7,}").matcher(u.getEmail()).matches()) {
			errors.rejectValue("email", null, "enter abcd@abc.com format");
		}
		if (!Pattern.compile("[a-zA-Z0-9#]{4,8}").matcher(u.getPassword()).matches()) {
			errors.rejectValue("password", null, "4-8 characters are allowed");
		}
		if (!Pattern.compile("[0-9]{10}").matcher(u.getPhno()).matches()) {
			errors.rejectValue("phno", null, "4-8 characters are allowed");
		}

		/*if ((ob.getClass().getName()).equals(Users.class.getName())) {
			Users u = (Users) ob;
			if (!Pattern.compile("[a-zA-Z]{2,15}").matcher(u.getUsername()).matches()) {
				errors.rejectValue("username", null, "only alphabets are allowed");
			}
			if (!Pattern.compile("[a-zA-Z@.0-9]{7,}").matcher(u.getEmail()).matches()) {
				errors.rejectValue("email", null, "enter abcd@abc.com format");
			}
			if (!Pattern.compile("[a-zA-Z0-9#]{4,8}").matcher(u.getPassword()).matches()) {
				errors.rejectValue("password", null, "4-8 characters are allowed");
			}
			if (!Pattern.compile("[0-9]{10}").matcher(u.getPhno()).matches()) {
				errors.rejectValue("phno", null, "4-8 characters are allowed");
			}
		}*/

	}

}
