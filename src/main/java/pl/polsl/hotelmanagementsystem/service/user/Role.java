package pl.polsl.hotelmanagementsystem.service.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CLIENT, ROLE_STAFF,
    ROLE_MANAGER, ROLE_KITCHEN, ROLE_ROOM_SERVICE, ROLE_RECEPTION;
    public String getAuthority(){
        return name();
    }
}
