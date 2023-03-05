package hello.core.user;

public interface UserRepository {

    void store(User user);
    User askById(Long userId);
}
