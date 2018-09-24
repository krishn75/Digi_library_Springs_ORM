package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Service.Interfaces.IUser_service;
import com.app.Validator.Validator_cls;
import com.app.model.Users;

@Controller
public class User_Controller {
	@Autowired
	private Validator_cls v;
	
	@Autowired
	private IUser_service ius;
	
	@GetMapping("/reg")
	public String user_Rpage(ModelMap mp)
	{
		mp.addAttribute("user", new Users());
		return "users";
	}
	
	@PostMapping("/userreg")
	public String User_register_insert(@ModelAttribute("user")Users u,Errors errors,ModelMap mp)
	{
		v.validate(u, errors);
		if(!errors.hasErrors()) {
			u.setRole("");
			u.setApproved("NO");
			int id=ius.Insert_User(u);
			mp.addAttribute("msg", "Successfully registered with user id= "+id);
			
			return "success";

		}
		else {
			mp.addAttribute("msg","failed to regster try again after rectifying errors");
			return "users";

		}
		
	}
	@GetMapping("/admin")
	public String admin(ModelMap mp)
	{
		return "Admin_Page";
	}
	
	@GetMapping("/select")
	public String user_List(ModelMap mp)
	{
		mp.addAttribute("users", ius.select_Users_list());
		return "Admin_users";
	}
	
	@GetMapping("/approve")
	public String user_ApprovePage(@RequestParam("id")int id,ModelMap mp)
	{
	
		mp.addAttribute("user", ius.select_User(id));
		return "users_update_admin";
	}
	
	@PostMapping("/Approvereg")
	public String User_Approve_insert(@ModelAttribute("user")Users u,Errors errors,ModelMap mp)
	{
		
		v.validate(u, errors);
		if(!errors.hasErrors()) {
			
			int id=ius.Update_User(u);
			mp.addAttribute("msg", "Successfully updated user ");
			
		
			return "success";

		}
		else {
			mp.addAttribute("msg","failed to regster try again after rectifying errors");
			return "failure";

		}
		
	}

}
