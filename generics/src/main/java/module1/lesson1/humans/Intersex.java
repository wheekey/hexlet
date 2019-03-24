package module1.lesson1.humans;

public class Intersex implements Human{
    private final String name;

    public Intersex(String name) {
        this.name = name;
    }

    @Override
    public Sex getSex() {
        return Sex.I;
    }

    @Override
    public String getName() {
        return name;
    }
}
