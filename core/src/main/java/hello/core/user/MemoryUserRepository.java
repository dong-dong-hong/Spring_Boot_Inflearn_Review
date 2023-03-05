package hello.core.user;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{

    private static final Map<Long, User> store = new HashMap<>();

    @Override
    public void store(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User askById(Long userId) {
        return store.get(userId);
    }
}
