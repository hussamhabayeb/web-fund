package com.example.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.Repository.ProjectRepository;
import com.example.project.models.LoginUser;
import com.example.project.models.Project;
import com.example.project.models.User;
import com.example.project.services.ProjectService;
import com.example.project.services.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class AppController {
	 @Autowired
     private UserService userServ;
	 
	 
	 @Autowired
	 private ProjectService projectService;
	 
	 
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "login_reg.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "login_reg.jsp";
	        }
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/dashbord";
	    }
	 
	 
	 
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
		    	System.out.println("solo");
	            model.addAttribute("newUser", new User());
	            return "login_reg.jsp";
	        }
	        
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/dashbord";
	    }
	 
	 
	 
	 @GetMapping("/dashbord")
	 public String home(Model model, HttpSession session) {
		 System.out.println(session.getAttribute("user_id"));
	     if (session.getAttribute("user_id") != null) {
	    	 System.out.println("zolo");
	         Long user_id = (Long) session.getAttribute("user_id");
	         User thisUser = userServ.findUserById(user_id);
	    
	         //////////////////////
	         
	 		model.addAttribute("user", thisUser);
	 		model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(thisUser));
	 		model.addAttribute("assignedProjects", projectService.getAssignedProjects(thisUser));
	         
	         
	         return "home.jsp";
	     } else {
	    	 System.out.print("not logged");
	         return "redirect:/";
	     }
	 }

	 
	 
	 @GetMapping("/logout")
	    public String logout( HttpSession session) {
	    	Long user_id = (Long) session.getAttribute("user_id");
	    	session.invalidate();
	    	return "redirect:/";
	    }
	 
	 @GetMapping("/project/new")
	 public String showNewProject(@ModelAttribute("project") Project project,Model model,HttpSession session ) {
		 System.out.println("husssamhab");
		 if (session.getAttribute("user_id") != null) {
			 System.out.println("abd");
			 Long userId = (Long) session.getAttribute("user_id");
	         
	         model.addAttribute("userId", userId);
	         return "creat_p.jsp";
		 }
		 
			return "redirect:/";
	 }
	 
	 
	 @PostMapping("/projects/new")
	 public String makeNewProject(@Valid @ModelAttribute("project") Project project, 
     BindingResult result, Model model, HttpSession session)  {
		 System.out.println(session.getAttribute("user_id"));
			if(session.getAttribute("user_id") == null) {
				
				return "redirect:/";
			}
			
			if(result.hasErrors()) {
				System.out.println("lacasssaaaa");
				return "creat_p.jsp";
			}else {
				projectService.addProject(project);
				
				Long userId = (Long) session.getAttribute("user_id");
				User user = userServ.findUserById(userId);
				user.getProjects().add(project);
				userServ.updateUser(user);
				return "redirect:/dashbord";
			}
		}
	 
	 @GetMapping("/dashboard/join/{id}")
	 public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		 System.out.println(session.getAttribute("user_id"));
		 if (session.getAttribute("user_id")==null) {
			 return "redirect:/";
		 }
		 Long userId=(Long)session.getAttribute("user_id");
		 
		 
		 Project project=projectService.findProject(id);
		 User user=userServ.findUserById(userId);
		 List<Project> projects=user.getProjects();
		 projects.add(project);
		 user.setProjects(projects);
		 userServ.updateUser(user);
		 
		 return "redirect:/dashbord";
	 }
	 
	 @GetMapping("/projects/edit/{id}")
	 public String showEditProject(@PathVariable("id") Long id,@ModelAttribute("project") Project project,Model model,HttpSession session ) {
		 System.out.println("husssamhab");
		 if (session.getAttribute("user_id") != null) {
			 System.out.println("editMethod");
			 Long userId = (Long) session.getAttribute("user_id");
			  Project project1=projectService.findProject(id);
			  model.addAttribute("project", project1);
	         model.addAttribute("userId", userId);
	         
	         return "edit_p.jsp";
		 }
		 
			return "redirect:/";
	 }
	 
	 
	 @PutMapping("/projects/edit/{id}")
	 public String submitEditProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
	    		@PathVariable("id") Long id,HttpSession session)  {
		 System.out.println(session.getAttribute("1111"));
			if(session.getAttribute("user_id") == null) {
				 System.out.println(session.getAttribute("2222222"));
				return "redirect:/";
			}
			
			if(result.hasErrors()) {
				System.out.println("abdooooooon");
				return "edit_p.jsp";
			}else {
				 System.out.println(session.getAttribute("donee"));
				 projectService.updateProject(project);
					Long userId = (Long) session.getAttribute("user_id");
					User user = userServ.findUserById(userId);
					user.getProjects().add(project);
					userServ.updateUser(user);
				return "redirect:/dashbord";
			}
}
	 
	 
	 @GetMapping("/projects/{project_id}")
	 public String showProject(@PathVariable("project_id") Long id,@ModelAttribute("project") Project project,Model model,HttpSession session ) {
		 System.out.println("detailsss");
		 if (session.getAttribute("user_id") != null) {
			 System.out.println("in_details");
			 Long userId = (Long) session.getAttribute("user_id");
	        
	         Project project1=projectService.findProject(id);
	         model.addAttribute("project", project1);
	         model.addAttribute("userId", userId);
	         
	         return "details_p.jsp";
		 }
		 
			return "redirect:/";
	 }
	 @RequestMapping("/projects/delete/{id}")
		public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
			
			if(session.getAttribute("user_id") == null) {
				return "redirect:/logout";
			}
			
			Project project = projectService.findProject(id);
			projectService.deleteProject(project);
			
			return "redirect:/dashbord";
		}
	 @RequestMapping("/dashboard/leave/{id}")
		public String leaveTeam(@PathVariable("id") Long id, HttpSession session,Model model) {
			
			if(session.getAttribute("user_id") == null) {
				return "redirect:/logout";
			}
			
			Long userId = (Long) session.getAttribute("user_id");
			
			Project project = projectService.findProject(id);
			User user = userServ.findUserById(userId);
			
			user.getProjects().remove(project);
			userServ.updateUser(user);
			
			model.addAttribute("user", user);
			model.addAttribute("unassignedProjects", projectService.getUnassignedProjects(user));
			model.addAttribute("assignedProjects", projectService.getAssignedProjects(user));
			
			return "redirect:/dashbord";
		}
		}
	 

