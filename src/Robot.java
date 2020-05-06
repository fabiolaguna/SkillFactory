public class Robot extends Specie {

    private static double robotMaxSpeed = 60;
    private static double robotMinSpeed = 30;

    public Robot(){
        double speed = Math.random()*(robotMaxSpeed-robotMinSpeed) + robotMinSpeed;
        setSpeed(speed);
    }
}
