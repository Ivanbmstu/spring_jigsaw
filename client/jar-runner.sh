#!/usr/bin/env bash

java -p "./build/libs:./build/lib/mp" -cp "./build/lib/cp/*" "$@" \
--patch-module jaxb.impl=./build/lib/cp/jaxb-core-2.3.0.1.jar \
--add-opens java.base/java.util=xstream \
--add-opens java.base/java.lang.reflect=xstream \
--add-opens java.base/java.text=xstream \
--add-opens java.desktop/java.awt.font=xstream \
--add-reads client.main=ALL-UNNAMED \
-m client.main/com.example.front.FrontApplication
