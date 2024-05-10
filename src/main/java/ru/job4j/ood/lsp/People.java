package ru.job4j.ood.lsp;

public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    class TestPeopleToWork {
        private People people;

        public TestPeopleToWork(People people) {
            this.people = people;
        }

        public void test() {
            if (people.age > 30) {
                throw new IllegalArgumentException("not passed");
            }
            if (people.name.startsWith("Z")) {
                throw new IllegalArgumentException("we dont want some Zorro`s on our company");
            }
        }
    }

    class SomeCompany extends TestPeopleToWork {

        public SomeCompany(People people) {
            super(people);
        }

        public void test() {
            /* Забыли сделать проверку. Возможно не валидное состояние */
        }
    }
}
