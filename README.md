# spring_jigsaw
Spring and jigsaw example with spring cloud feign depndency 


Branches:
step0: стартовый проект
step1: нет модулей, запуск на classpath, пофикшены зависимости на jaxb, удаленный из Java 11 
step2: добавлен module-info, сборка в gradle с опцией --module-path
step3: добавлены зависимости на другие модули
step4: пофикшены split packages, добавлены методы в build.gradle для создания опций запуска/компиляции
step5: финальный результат для сборки с тестами
step6: финальный результат, запуск модуля через jar-runner.sh
