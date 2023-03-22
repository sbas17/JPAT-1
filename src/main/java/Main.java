public class Main {
    public static void main(String[] args) throws IllegalStateException, IllegalArgumentException {
        Person mom = new PersonBuilder().setName("Анна").setSurname("Вольф").setAge(31).setAddress("Сидней").build();
        Person son = mom.newChildBuilder().setName("Антошка").build();
        System.out.println("У " + mom + " есть сын, " + son);

//        Person dad = new PersonBuilder().setName("Алексей").setAge(31).setAddress("Сидней").build();
//        System.out.println(dad);

        Person person = new PersonBuilder()
                .setName("SomeName")
                .setSurname("SomeName")
                .build();
        System.out.println(person.hasAge());

//        Person grandMother = new PersonBuilder().setName("Ирина").setSurname("Вольф").setAge(-100).build();
//        System.out.println(grandMother);
    }
}