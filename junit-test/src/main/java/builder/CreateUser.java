package builder;

public class CreateUser {


    public static void main(String[] args) {



        User user1 = new User("John", "Doe");
        user1.setAge(100);
        user1.setPhone("1234567");
        user1.setAddress("Fake address 1234");


        User user2 = new User("John", "Doe", 100);
        user2.setPhone("1234567");
        user2.setAddress("Fake address 1234");


        User user3 = new User("John", "Doe", 100, "1234567");
        user3.setAddress("Fake address 1234");

        User user4 = new User("John", "Doe", 100, "1234567", "Fake address 1234");


        NewUser user5  = new NewUser.UserBuilder("John", "Doe")
                .age(100)
                .phone("1234567")
                .address("Fake address 1234")
                .build();


        String x = "";


    }





}
