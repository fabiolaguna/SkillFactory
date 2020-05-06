public class Dog extends Specie {

    private static double dogMaxSpeed = 50;
    private static double dogMinSpeed = 20;

    public Dog(){
        double speed = Math.random()*(dogMaxSpeed-dogMinSpeed) + dogMinSpeed;
        setSpeed(speed);
    }
}
