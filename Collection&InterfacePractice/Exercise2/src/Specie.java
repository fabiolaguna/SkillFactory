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

    abstract public String getSpecie();

    @Override
    public String toString() {
        return "NAME: " + name + "\nSPEED: " + String.format("%.1f", speed) + " km/h\n";
    }
}
