#!/usr/bin/env bash
rm ./build/lib/mp/javax.activation-api-1.2.0.jar
java -p "./build/libs:./build/lib/mp" -cp "./build/lib/cp/*" "$@" \
--patch-module java.annotation=./build/lib/pm/jsr305-3.0.1.jar \
--add-opens java.base/java.lang=spring.core \
-m client.main/com.example.front.FrontApplication