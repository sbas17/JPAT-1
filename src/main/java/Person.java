import java.util.OptionalInt;

public class Person {
    protected String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public boolean hasAge() {
        if (age != null) {
            System.out.println(name + ": возраст " + age.getAsInt());
            return true;
        } else {
            System.out.println(name + ": возраст не установлен");
            // ... возможно нужно выбросить исключение, в зависимости от задания
        }
        return false;
    }

    public boolean hasAddress() {
        if (address.equals(null)) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age != null) {
            throw new IllegalArgumentException("Возраст уже установлен");
        } else {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Недопустимое значение возраста");
            }
            this.age = OptionalInt.of(age);
        }

    }

    public String getAddress() {
        if (address == null) {
            return "Адрес не установлен";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge() == true) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        } else {
            throw new IllegalArgumentException("Возраст неизвестен");
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder(null, surname, 0, address);
        return child;
    }

    @Override
    public String toString() {
        return "[" + name + " " + surname + " (Адрес: " + (address != null ? this.address : "Значение адреса не установлено") +
                "; Возраст: " + (age != null ? age.getAsInt() : "Значение возраста не установлено") +
                ")]";
    }


    @Override
    public int hashCode() {
        return this.hashCode();
    }

}