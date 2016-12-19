
public class Cat extends Pet {
    private int color;

    @Override
    public String toString() {
        return "Cat{" +
                "color=" + color +
                '}';
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}


