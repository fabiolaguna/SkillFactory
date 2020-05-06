public class Human extends Specie {

    private static double humanMaxSpeed = 40;
    private static double humanMinSpeed = 15;

    public Human(){
        double speed = Math.random()*(humanMaxSpeed-humanMinSpeed) + humanMinSpeed;
        setSpeed(speed);
    }
}
