import java.util.OptionalInt;

public class PersonBuilder {
    public String name;
    public String surname;
    public OptionalInt age;
    public String address;

    public PersonBuilder(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PersonBuilder(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < -1 && age > 150) {
            throw new IllegalArgumentException("Указано недопустимое значение возраста");
        } else {
            this.age = OptionalInt.of(age);
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null)
            throw new IllegalStateException ("Не заполнено обязательные поля ИМЯ и/или ФАМИЛИЯ");
        Person person = new Person(name, surname);
        if (age != null) person.setAge(age.getAsInt());
        person.setAddress(this.address);
        return person;


    }
}