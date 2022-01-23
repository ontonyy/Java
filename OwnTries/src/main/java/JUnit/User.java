package JUnit;


import java.util.*;
import java.util.stream.Collectors;

public class User {
    private int id;
    private int age;
    private Sex sex;
    private String name;
    private static Map<Integer, User> allUsers = new HashMap<>();
    private static int countId = 0;

    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.age = age;
            this.sex = sex;
            this.name = name;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex) {
        return allUsers.values().stream().filter(user -> user.sex == sex).collect(Collectors.toList());
    }

    public static int getHowManyUsers() {
        return getAllUsers().size();
    }

    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user: getAllUsers()) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User user: getAllUsers(sex)) {
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAgeAverageUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAgeAverageUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                sex == user.sex;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, sex);
    }
}
