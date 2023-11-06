package haagahelia.fi.TaskMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import haagahelia.fi.TaskMaster.Model.UserRepository;
import haagahelia.fi.TaskMaster.Model.AppUser;
import haagahelia.fi.TaskMaster.Model.TaskRepository;

@SpringBootApplication
public class TaskMasterApplication {
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;  

	public static void main(String[] args) {
		SpringApplication.run(TaskMasterApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner demo(TaskRepository repository, UserRepository userRepository) {
        return (args) -> {
        	userRepository.save(new AppUser("user", passwordEncoder.encode("user123")));
        	
        };
    }

}
