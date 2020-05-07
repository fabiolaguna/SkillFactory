public class Main {

    public static void main(String[] args) {

        Marathon marathon = new Marathon();

        Dog dog1 = new Dog("Firulais");
        Dog dog2 = new Dog("Fluffy");
        Human human2 = new Human("Eduardo");
        Human human3 = new Human("Alejandro");
        Robot robot1 = new Robot("Bender");
        Robot robot2 = new Robot("Robocop");

        marathon.addRunner(dog1);
        marathon.addRunner(dog2);
        marathon.addRunner(human2);
        marathon.addRunner(human3);
        marathon.addRunner(robot1);
        marathon.addRunner(robot2);

        System.out.println(marathon.startMarathon());
    }
}
