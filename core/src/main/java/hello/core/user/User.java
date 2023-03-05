package hello.core.user;

public class User {

    private long id;
    private String name;
    private Rank rank;

    public User(long id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
