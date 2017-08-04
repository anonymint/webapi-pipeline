#!/bin/bash
ps aux | grep java
# wait for java to spin up tomcat 10 is enough for now
sleep 10
curl http://localhost:8000
