package hello.core.user;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(User user) {
        userRepository.store(user);
    }

    @Override
    public User AskRank(Long userId) {
        return userRepository.askById(userId);
    }
}
