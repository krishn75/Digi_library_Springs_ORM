package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.Service.Interfaces.IUser_service;
import com.app.Validator.Validator_cls;
import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Issued_books;
import com.app.model.Users;

@Controller
public class User_Controller {
	@Autowired
	private Validator_cls v;

	@Autowired
	private IUser_service ius;
	
	@Autowired
	private UserDetailsService lds;
	// login module

	@GetMapping({ "/Login", "/" })
	public String loginPage() {
		return "login";
	}
	
	

	@PostMapping("/home")
	public String login_success(ModelMap mp) {

		String un = SecurityContextHolder.getContext().getAuthentication().getName();
		String auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		if (auth.contains("ADMIN")) {
			mp.addAttribute("msg", "Welcome ADMIN " + un);
			return "Admin_Page";

		} else if (auth.contains("USER")) {
			mp.addAttribute("msg", "Welcome USER " + un);
			return "User_Page";
		}
		return "success";
	}

	// user module
	@GetMapping("/reg")
	public String user_Rpage(ModelMap mp) {
		mp.addAttribute("user", new Users());
		return "users";
	}

	@PostMapping("/userreg")
	public String User_register_insert(@RequestBody Users u, Errors errors, ModelMap mp) {
		v.validate(u, errors);
		if (!errors.hasErrors()) {
			u.setRole("");
			u.setApproved("NO");
			int id = ius.Insert_User(u);
			mp.addAttribute("msg", "Successfully registered with user id= " + id);

			return "success";

		} else {
			mp.addAttribute("msg", "failed to regster try again after rectifying errors");
			return "users";

		}

	}

	// user roles update by admin module
	@GetMapping("/admin")
	public String admin(ModelMap mp) {
		return "Admin_Page";
	}

	@GetMapping("/select")
	public String user_List(ModelMap mp) {
		mp.addAttribute("users", ius.select_Users_list());
		return "Admin_users";
	}

	@GetMapping("/approve")
	public String user_ApprovePage(@RequestParam("un") String un, ModelMap mp) {

		mp.addAttribute("user", ius.select_User(un));
		return "users_update_admin";
	}

	@PostMapping("/Approvereg")
	public String User_Approve_insert(@ModelAttribute("user") Users u, Errors errors, ModelMap mp) {
		int id = ius.Update_User(u);

		if (id > 0) {

			mp.addAttribute("msg", "Successfully updated user ");

			return "success";

		} else {
			mp.addAttribute("msg", "failed to regster try again after rectifying errors");
			return "failure";

		}

	}

	// category module

	@GetMapping("/cat")
	public String category_Page(ModelMap mp) {

		mp.addAttribute("category", new Category());
		return "category";
	}

	@PostMapping("/catreg")
	public String category_insert(@ModelAttribute("category") Category c, Errors errors, ModelMap mp) {

		v.validate(c, errors);
		if (!errors.hasErrors()) {

			int id = ius.Insert_cat(c);
			mp.addAttribute("msg", "Successfully updated category with id= " + id);

			return "category";

		} else {
			mp.addAttribute("msg", "failed to regster try again after rectifying errors");
			return "category";

		}

	}
	// books entry module

	@GetMapping("/book")
	public String books_Page(ModelMap mp) {

		mp.addAttribute("book", new Books());
		mp.addAttribute("cat", ius.select_cat_list());
		return "books";
	}

	@PostMapping("/bookreg")
	public String book_insert(@ModelAttribute("book") Books b, Errors errors, ModelMap mp) {

		v.validate(b, errors);
		if (!errors.hasErrors()) {

			int id = ius.Insert_Book(b);
			mp.addAttribute("msg", "Successfully register book with id= " + id);
			mp.addAttribute("cat", ius.select_cat_list());
			return "books";

		} else {
			mp.addAttribute("msg", "failed to regster try again after rectifying errors");
			mp.addAttribute("cat", ius.select_cat_list());
			return "books";

		}

	}

	// user page
	@GetMapping("/user")
	public String user_Page() {

		return "User_Page";
	}

	// search books
	@GetMapping("/books_list")
	public String books_List(ModelMap mp) {
		mp.addAttribute("data", ius.select_Books_list());
		return "Books_search";
	}

	// issue book
	@GetMapping("/Issue_Book/{bid}/{qty}")
	public String issue_Book(@PathVariable("bid") int id, @PathVariable("qty") int qty, ModelMap mp) {
		String un = SecurityContextHolder.getContext().getAuthentication().getName();

		Issued_books i = new Issued_books();
		i.setIid(ius.generate());
		i.setBook_id(id);
		i.setIusername(un);
		i.setStatus("NOT RETURNED");
		String msg = ius.Issue_Book(i, qty);
		mp.addAttribute("msg", msg);

		return "success";
	}

	// return books
	@GetMapping("/return_page")
	public String return_page(ModelMap mp) {
		String un = SecurityContextHolder.getContext().getAuthentication().getName();
		mp.addAttribute("data", ius.Return_books(un));
		return "return_page";
	}

	@GetMapping("/Return_Book")
	public String Return_Book_reg(@RequestParam("i") int id, @RequestParam("q") int qty, ModelMap mp) {
		String un = SecurityContextHolder.getContext().getAuthentication().getName();
		String msg = ius.return_Book_reg(id, qty, un);
		mp.addAttribute("msg", msg);
		return "success";

	}

	// ajax
	@RequestMapping("/checkId")
	public @ResponseBody String checkIdData(@RequestParam("eun") String eun) {
		String msg = "";
		Users u = ius.select_User(eun);
		if (u != null) {
			msg = eun + "  already exist in DB.";
		}
		return msg;
	}

}
