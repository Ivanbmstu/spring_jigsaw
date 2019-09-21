package deps;

public class Common {
    public void common() {
        Module module = Common.class.getModule();
        System.out.println(module);
        System.out.println(module.getLayer());
    }
}
