package module1.lesson3.humans;

public class Man implements Human {

    private final String name;
    private final Sex sex;

    public Man(String name, Sex incomeSex) {
        this.name = name;
        this.sex = incomeSex;
    }

    @Override
    public Sex getSex() {
        return sex;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        boolean j = false;
        if (!(o instanceof Man)) return false;

        Man man = (Man) o;
        if (this.name.equals(man.name) && this.sex == man.sex || man.name.equals(this.name) && man.sex == this.sex) {
            j = true;
        }
        return j;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }
}