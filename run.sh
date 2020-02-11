#!/bin/sh

echo "********************************************************"
echo "Starting Transaction Agent Service ..."
echo "********************************************************"
java -Ddebug=$DEBUG_MODE \
     -Dserver.port=$SERVERPORT -jar /usr/src/app/transactionagentservice-0.0.1-SNAPSHOT.jar
