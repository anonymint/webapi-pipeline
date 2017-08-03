#!/bin/bash
ps aux | grep java
sleep 10
curl http://127.0.0.1:8000
curl http://localhost:8000
