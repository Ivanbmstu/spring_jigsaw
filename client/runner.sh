#!/usr/bin/env bash

java -p "./build/classes/java/main/:./libs/module" -cp "./libs/cp/*" "$@" \
--add-opens java.base/java.util=xstream \
--add-opens java.base/java.lang.reflect=xstream \
--add-opens java.base/java.text=xstream \
--add-opens java.desktop/java.awt.font=xstream \
--add-reads front.module=ALL-UNNAMED \
-m front.module/com.example.front.FrontApplication