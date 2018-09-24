package com.app.Validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Users;

@Component
public class Validator_cls implements Validator {

	@Override
	public boolean supports(Class<?> clz) {
		if (Users.class.equals(clz)) {
			return true;
		} else if (Category.class.equals(clz)) {
			return true;
		} else if (Books.class.equals(clz)) {
			return true;
		}

		else {
			return false;
		}

	}

	@Override
	public void validate(Object ob, Errors errors) {
		/*
		 * Users u = (Users) ob; if
		 * (!Pattern.compile("[a-zA-Z]{2,15}").matcher(u.getUsername()).matches()) {
		 * errors.rejectValue("username", null, "only alphabets are allowed"); } if
		 * (!Pattern.compile("[a-zA-Z@.0-9]{7,}").matcher(u.getEmail()).matches()) {
		 * errors.rejectValue("email", null, "enter abcd@abc.com format"); } if
		 * (!Pattern.compile("[a-zA-Z0-9#]{4,8}").matcher(u.getPassword()).matches()) {
		 * errors.rejectValue("password", null, "4-8 characters are allowed"); } if
		 * (!Pattern.compile("[0-9]{10}").matcher(u.getPhno()).matches()) {
		 * errors.rejectValue("phno", null, "4-8 characters are allowed"); }
		 */

		if ((ob.getClass().getName()).equals(Users.class.getName())) {
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
		} else if ((ob.getClass().getName()).equals(Category.class.getName())) {
			Category c = (Category) ob;
			if (!Pattern.compile("[a-zA-Z_]{2,15}").matcher(c.getC_name()).matches()) {
				errors.rejectValue("C_name", null, "only alphabets are allowed and underscore is allowed");
			}

		}else if ((ob.getClass().getName()).equals(Books.class.getName())) {
			Books b = (Books) ob;
			if (!Pattern.compile("[a-zA-Z ]{2,15}").matcher(b.getTitle()).matches()) {
				errors.rejectValue("title", null, "only alphabets are allowed");
			}
			if (!Pattern.compile("[a-zA-Z0-9_ ]{7,}").matcher(b.getDescription()).matches()) {
				errors.rejectValue("description", null, "enter abcd@abc.com format");
			}
			if (!Pattern.compile("[a-zA-Z ]{2,15}").matcher(b.getPublisher()).matches()) {
				errors.rejectValue("publisher", null, "4-8 characters are allowed");
			}
			/*if (!Pattern.compile("[0-9]{4}").matcher(b.getYear()+"").matches()) {
				errors.rejectValue("year", null, "4-8 characters are allowed");
			}
			if (!Pattern.compile("[0-9]{0,15}").matcher(b.getQuantity()+"").matches()) {
				errors.rejectValue("quantity", null, "4-8 characters are allowed");
			}*/
		}

	}

}
