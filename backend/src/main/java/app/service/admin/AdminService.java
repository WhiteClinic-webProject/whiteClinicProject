package app.service.admin;

import app.model.entity.admin.AdminEntity;
import app.model.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String adminname) throws UsernameNotFoundException {
        AdminEntity adminEntity = adminRepository.findByAdminname(adminname)
                .orElseThrow(() -> new UsernameNotFoundException("찾을 수 없다."));

        return User.builder()
                .username(adminEntity.getAdminname())
                .password(adminEntity.getAdminpassword())
                .roles(adminEntity.getRole())
                .build();
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

