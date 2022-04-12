package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Konstantin");
        student.setSurname("Ibiza");
        student.setPatronymic("Pavlovich");
        student.setGroup(411);
        student.setDate("24.09.2000");

        System.out.println("Студент - " + student.getName() + " " + student.getSurname() + " " + student.getPatronymic() + " "
                + "находится в группе " + student.getGroup() + " , " + "начал обучение с : " + student.getDate());
    }
}
