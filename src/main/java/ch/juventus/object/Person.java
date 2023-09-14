package ch.juventus.object;

public class Person {

    private final String firstName;
    private final String lastName;
    private final Address address;
    private final int age;
    private final boolean hasPets;

    public Person(String firstName, String lastName, Address address, int age, boolean hasPets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.hasPets = hasPets;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasPets() {
        return hasPets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", age=" + age +
                ", hasPets=" + hasPets +
                '}';
    }
}
