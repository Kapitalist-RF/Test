package app.entity;

public class User {

    private int id;
    private String name;
    private String password;
    private String jwt;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String jwt) {
        this.id = id;
        this.name = name;
        this.jwt = jwt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getId() {
        return id;
    }
}
