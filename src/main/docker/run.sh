#!/bin/sh

echo "********************************************************"
echo "Starting Transaction Agent Service ..."
echo "********************************************************"
java -Ddebug=$DEBUG_MODE                                                    \
     -Dspring.profiles.active=$PROFILE -jar /usr/local/transactionagentservice/@project.build.finalName@.jar
