#!/bin/bash

#source $0 # running script in current shell than opening a new one
chmod +x $0

export DB_HOST=localhost:3306
export DB_NAME=onlineshopping
export DB_USERNAME="root"
export DB_PASSWORD="root1234"


#echo DB_HOST=$DB_HOST
#echo DB_NAME=$DB_NAME
#echo DB_USERNAME=$DB_USERNAME
printenv | grep DB_

#mvn spring-boot:run