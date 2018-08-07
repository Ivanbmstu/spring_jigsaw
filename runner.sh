#!/usr/bin/env bash

# увы и ах jar запустить с модулями не удастся см jar --describe-module --file=./build/libs/demo-0.0.1-SNAPSHOT.jar 
# удастся запустить просто проект, но не с модулем из module-info 
java -p ./build/libs/demo-0.0.1-SNAPSHOT.jar --add-modules java.sql --show-module-resolution -m demo