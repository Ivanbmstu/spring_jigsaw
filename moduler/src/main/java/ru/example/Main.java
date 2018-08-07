package ru.example;

import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ModuleFinder.of(Paths.get("/Users/ivanpohodnya/IdeaProjects/jpms/ddd/build/libs/demo-0.0.1-SNAPSHOT.jar"))
                .findAll().stream().map(ModuleReference::descriptor).map(ModuleDescriptor::name).forEach(System.out::println);
    }
}
