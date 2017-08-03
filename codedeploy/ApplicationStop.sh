#!/bin/bash
kill $(ps aux | grep '[s]impleapi' | awk '{print $2}')
exit 0
