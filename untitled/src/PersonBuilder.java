public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = 5;
    protected String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле имя не заполнено");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Поле фамилия не заполнено");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Введено недопустимое значение возраста");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Не заполнены обязательный поля");
        }
        if (age < 0) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        person.setAddress(address);
        return person;
    }
}