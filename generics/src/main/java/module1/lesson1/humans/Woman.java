package module1.lesson1.humans;

public class Woman implements Human {

    private final String name;

    public Woman(String name) {
        this.name = name;
    }

    @Override
    public Sex getSex() {
        return Sex.F;
    }

    @Override
    public String getName() {
        return name;
    }
}
