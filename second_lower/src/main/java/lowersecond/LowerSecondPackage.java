package lowersecond;

import deps.Common;

public class LowerSecondPackage {

    public void execute() {
        Common common = new Common();
        common.common();

        Module module = LowerSecondPackage.class.getModule();
        System.out.println(module);
        System.out.println(module.getLayer());
        System.out.println(module.getClassLoader());
    }
}
