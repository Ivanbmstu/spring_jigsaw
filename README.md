# spring_jigsaw
Spring and jigsaw example with spring cloud feign depndency 


Branches:<br>
step0: стартовый проект<br>
step1: нет модулей, запуск на classpath, пофикшены зависимости на jaxb, удаленный из Java 11 <br>
step2: добавлен module-info, сборка в gradle с опцией --module-path<br>
step3: добавлены зависимости на другие модули<br>
step4: пофикшены split packages, добавлены методы в build.gradle для создания опций запуска/компиляции<br>
step5: финальный результат для сборки с тестами<br>
step6: финальный результат, запуск модуля через jar-runner.sh<br>
