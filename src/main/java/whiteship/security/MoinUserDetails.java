package whiteship.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import whiteship.domain.Account;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Keeun Baik
 */
public class MoinUserDetails implements UserDetails {

    private Account account;

    public MoinUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(account.isAdmin()) {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Account getAccount() {
        return account;
    }
}
