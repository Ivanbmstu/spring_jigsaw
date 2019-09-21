package lower;

import deps.Common;

public class Lower {

    public void execute() {
        Common common = new Common();
        common.common();

        Module module = Lower.class.getModule();
        System.out.println(module);
        System.out.println(module.getLayer());
        System.out.println(module.getClassLoader());
    }
}
