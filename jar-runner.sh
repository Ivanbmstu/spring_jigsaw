#!/usr/bin/env bash
rm ./client/build/lib/mp/javax.activation-api-1.2.0.jar
java -p "./client/build/libs:./client/build/lib/mp" -cp "/client/build/lib/cp/*" \
--patch-module java.annotation=./client/build/lib/pm/jsr305-3.0.1.jar \
--add-opens java.base/java.lang=spring.core \
-m client.main/com.example.front.FrontApplication