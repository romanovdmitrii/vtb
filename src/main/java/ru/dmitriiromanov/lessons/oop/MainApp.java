package ru.dmitriiromanov.lessons.oop;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human();
        Car car = new Car();
        Skateboard skateboard = new Skateboard();
        human.stop();
        human.drive(car);
        human.stop();
        human.drive(skateboard);
        human.stop();
    }

    static class Human {
        private Transport currentTransport;

       public void stop() {
            if (currentTransport != null) {
                currentTransport.stop();
                currentTransport = null;
            } else {
                System.out.println("Транспорт не выбран");
            }
        }

        public void drive(Transport transport) {
            transport.start();
            this.currentTransport = transport;
        }
    }

    static class Skateboard implements Transport {
        @Override
        public void start() {
            System.out.println("Начал движение на скейте");
        }

        @Override
        public void stop() {
            System.out.println("Остановил скейт");
        }
    }

    static class Bicycle implements Transport {
        @Override
        public void start() {
            System.out.println("Начал движение на велосипеде");
        }
    }

    static class Car implements Transport {
    }

}
