package ru.job4j.ood.ocp;

public class Android {
    public void systemAndroid() {
    }

    public static class Apple extends Android { /* Здесь нарушение OCP
     Должен быть интерфейс описывающий Операционную систему и от него уже наследоваться Apple и Android */

    }
}
