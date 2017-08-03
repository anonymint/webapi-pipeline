#!/bin/bash
java -jar /opt/simpleapi-0.0.1-SNAPSHOT.jar & echo $! > /dev/null 2>&1 & echo $! > /opt/pid.file
