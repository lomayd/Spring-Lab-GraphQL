package lomayd.SpringLabGraphQL.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lomayd.SpringLabGraphQL.api.domain.user.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}