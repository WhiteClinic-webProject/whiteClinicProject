package app.model.repository.admin;

import app.model.entity.admin.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    Optional<AdminEntity> findByAdminname(String adminname);
}
