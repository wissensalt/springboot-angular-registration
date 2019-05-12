package com.wissensalt.test.sar.model;

import com.wissensalt.test.sar.auditrail.AAuditTrail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 5/8/19.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Where(clause = "status=true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sec_user")
public class User extends AAuditTrail implements UserDetails {
    /**
     *
     *
     */
    private static final long serialVersionUID = 1170842867204324354L;

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    private static Date CURRENT_DATE = new Date();

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_number", unique = true, nullable = false)
    private String mobileNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Email(message = "Email must be valid")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired_date")
    private Date expiredDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "credentials_expired_date")
    private Date credentialsExpiredDate;

    @Column(name = "account_non_locked")
    private Boolean nonLocked;

    @Column(name = "login_status")
    private Boolean loginStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date lastLogin;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "link_user_role",
            joinColumns = {@JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )}
    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        for (Role role : getRoles()) {
            LOGGER.debug(role.getName());
        }
        return getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.getCode();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.getExpiredDate().compareTo(CURRENT_DATE) > 0;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.getNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.getCredentialsExpiredDate().compareTo(CURRENT_DATE) > 0;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }
}
