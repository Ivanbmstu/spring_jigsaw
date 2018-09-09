#!/usr/bin/env bash

java -p "./build/libs:./build/lib/mp" -cp "./build/lib/cp/*" "$@" \
--patch-module jaxb.impl=./build/lib/pm/jaxb-core-2.3.0.1.jar \
-m client.main/com.example.front.FrontApplication
