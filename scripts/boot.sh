#!/usr/bin/env bash
/usr/sbin/mysqld --user=mysql & sleep 3
java -jar /jetty/start.jar -Djetty.port=80 -Dupload.dir=/