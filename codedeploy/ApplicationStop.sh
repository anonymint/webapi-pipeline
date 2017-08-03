#!/bin/bash
kill $(ps aux | grep '[s]impleapi' | awk '{print $2}') > /dev/null 2>&1
exit 0
