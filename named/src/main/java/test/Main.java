package test;

import deps.DependentClass;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var x = new DependentClass();
        x.module();
        System.out.println(Main.class.getModule());
        ModuleLayer boot = ModuleLayer.boot();
        System.out.println(boot.modules());
        System.out.println(boot.parents());
        System.out.println(boot.findModule("dependent").get().equals(x.getClass().getModule()));

        "file:///Users/pohodnaivan/.m2/repository/test/example/lower/1.0/lower-1.0.jar";
        Configuration configuration = boot.configuration();
        URI lowerLocation = configuration.findModule("lower").get().reference().location().get();
        Configuration lower = configuration.resolve(ModuleFinder.of(Path.of(lowerLocation)),
                ModuleFinder.of(), List.of("lower"));
        ModuleLayer moduleLayer = boot.defineModulesWithManyLoaders(lower, ClassLoader.getSystemClassLoader());

        System.out.println(moduleLayer.modules());


    }
}
