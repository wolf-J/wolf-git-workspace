/**
 * 
 */
package wolf_j.com.github.relation.classmessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import wolf_j.com.github.relation.classmessage.presistence.User;
import wolf_j.com.github.relation.classmessage.presistence.UserRepository;

/**
 * @author wolf-J
 *
 */
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if( user == null ){
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }

        return user;

	}

}
