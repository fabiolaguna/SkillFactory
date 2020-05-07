public abstract class Specie {

    private String name;
    private double speed;

    public Specie(String name){
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "NAME: " + name + "  ||  SPEED: " + speed + "  ||  ";
    }
}
