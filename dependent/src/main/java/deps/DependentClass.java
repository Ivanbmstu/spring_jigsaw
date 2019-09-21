package deps;

public class DependentClass {

    public void module() {
        System.out.println(DependentClass.class.getModule());
    }
}
