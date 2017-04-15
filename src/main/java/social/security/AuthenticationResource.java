package social.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/api/session")
public class AuthenticationResource {

    protected static final Logger log = LoggerFactory.getLogger(AuthenticationResource.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    public User session(Principal user) {
        String name = user == null ? null : user.getName();
        log.info("/api/session: {}", name);
        return new User(name);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
