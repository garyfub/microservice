package zuul.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import zuul.service.AuthorityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        String requestMethod = request.getMethod();
        String requestUrl = request.getRequestURI();
        String requestAuthorityUrl = "[" + requestMethod + "]" + requestUrl;

        System.out.println("requestAuthorityUrl:");
        System.out.println(requestAuthorityUrl);

        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();

        for (SimpleGrantedAuthority authority:grantedAuthorityList             ) {
            System.out.println("authority:");
            System.out.println(authority);

            if(authority.getAuthority().equalsIgnoreCase(requestAuthorityUrl))
                return true;
        }
        return false;
    }
}
