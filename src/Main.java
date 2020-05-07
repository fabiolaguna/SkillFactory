public class Main {

    public static void main(String[] args) {

        Marathon marathon = new Marathon();

        Specie dog1 = new Dog("Firulais");
        Specie dog2 = new Dog("Fluffy");
        Specie human2 = new Human("Eduardo");
        Specie human3 = new Human("Alejandro");
        Specie robot1 = new Robot("Bender");
        Specie robot2 = new Robot("Robocop");

        marathon.addRunner(dog1);
        marathon.addRunner(dog2);
        marathon.addRunner(human2);
        marathon.addRunner(human3);
        marathon.addRunner(robot1);
        marathon.addRunner(robot2);

        System.out.println(marathon.startMarathon());
    }
}
