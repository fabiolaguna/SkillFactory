public class Human extends Specie implements ISprintable {

    private static double humanMaxSpeed = 40;
    private static double humanMinSpeed = 15;

    public Human(String name){
        super(name);
        double speed = Math.random()*(humanMaxSpeed-humanMinSpeed) + humanMinSpeed;
        setSpeed(speed);
    }

    @Override
    public double run(double distance) {
        return (distance/getSpeed());
    }
}
