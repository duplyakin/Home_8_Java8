
public class Dog extends Pet {
    private double speed;

    @Override
    public String toString() {
        return "Dog{" +
                "speed=" + speed +
                '}';
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
