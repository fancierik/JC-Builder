
public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Kate")
                .setSurname("Smitt")
                .setAge(31)
                .setAddress("NY")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Mat")
                .setAge(3)
                .build();
        System.out.println(mom + " \n Eсть сын " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}