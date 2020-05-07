public class Robot extends Specie implements ISprintable {

    private static double robotMaxSpeed = 60;
    private static double robotMinSpeed = 30;

    public Robot(String name){
        super(name);
        double speed = Math.random()*(robotMaxSpeed-robotMinSpeed) + robotMinSpeed;
        setSpeed(speed);
    }

    @Override
    public double run(double distance) {
        return (distance/getSpeed());
    }
}
