package ru.example;

import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String classpath = "/Users/ivanpohodnya/.gradle/caches/modules-2/files-2.1/javax.xml.bind/jaxb-api/2.3.0/99f802e0cb3e953ba3d6e698795c4aeb98d37c48/jaxb-api-2.3.0.jar";
        String modulePath = "";

        Set<ModuleReference> all = ModuleFinder.of(Paths.get(classpath)).findAll();
        int x = 5;
//        copyFromTo("/Users/ivanpohodnya/IdeaProjects/jpms/ddd/client/libs/module", modulePath);
//        copyFromTo("/Users/ivanpohodnya/IdeaProjects/jpms/ddd/client/libs/cp", classpath);

    }

    public static void copyFromTo(String toFolder, String paths) throws IOException {
        Path libFolderPath = Paths.get(toFolder);
        if (libFolderPath.toFile().exists()) {
            Files.walk(libFolderPath)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
        Files.createDirectories(libFolderPath);
        Arrays.stream(paths.split(":")).map(File::new).forEach(file -> {
            try {
                Files.copy(file.toPath(), libFolderPath.resolve(file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
