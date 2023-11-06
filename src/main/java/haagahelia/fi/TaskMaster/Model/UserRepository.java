package haagahelia.fi.TaskMaster.Model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);

}
