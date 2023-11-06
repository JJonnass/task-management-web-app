package haagahelia.fi.TaskMaster.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import haagahelia.fi.TaskMaster.Model.AppUser;
import haagahelia.fi.TaskMaster.Model.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
		@Autowired
		public UserDetailServiceImpl (UserRepository userRepository) {
			this.repository = userRepository;
		}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		
		UserBuilder  builder = null;
		if (curruser == null) {
			throw new UsernameNotFoundException("User not found");
		}
		else {
			builder = User.withUsername(username);
			builder.password(curruser.getPasswordHash());
		}
		return builder.build();
	}
}
