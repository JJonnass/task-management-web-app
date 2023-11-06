package haagahelia.fi.TaskMaster.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import haagahelia.fi.TaskMaster.Model.AppUser;
import haagahelia.fi.TaskMaster.Model.Task;
import haagahelia.fi.TaskMaster.Model.TaskRepository;
import haagahelia.fi.TaskMaster.Model.UserRepository;

@Controller
public class TaskMasterController {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private TaskRepository repository;
	
	@RequestMapping(value="/login") 
	public String login() {
		return "login";
	}	

	@RequestMapping(value={"/", "/tasklist"})
    public String taskList(Model model) {
    	model.addAttribute("tasks", repository.findAll());
    	return "tasklist";
    }
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long taskId, Model model) {
		repository.deleteById(taskId);
		return "redirect:../tasklist";
	}
	@RequestMapping(value="/add")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "addTask";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveTask(Task task) {
		if (task.getStatus() == null || task.getStatus().isEmpty()) {
	        task.setStatus("PENDING");
	    }
		repository.save(task);
		return "redirect:tasklist";
	}
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTaskStatus(@PathVariable("id") Long taskId) {
        Optional<Task> optionalTask = repository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus("DONE");
            repository.save(task);
        }
        return "redirect:../tasklist";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") AppUser user, Model model) {
        if (!user.getPasswordHash().equals(user.getRetypePassword())) {
            model.addAttribute("passwordMismatch", "Passwords do not match");
            return "registration";
        }

        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        userRepository.save(user);

        return "redirect:/login";
    }
}