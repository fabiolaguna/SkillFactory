public class Dog extends Specie implements ISprintable {

    private static double dogMaxSpeed = 50;
    private static double dogMinSpeed = 20;

    public Dog(String name){
        super(name);
        double speed = Math.random()*(dogMaxSpeed-dogMinSpeed) + dogMinSpeed;
        setSpeed(speed);
    }

    @Override
    public double run(double distance) {
        return (distance/getSpeed());
    }
}
