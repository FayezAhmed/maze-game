# Raccon Raiders
#
# @file
# @version 0.1


CC=mvn

all: build

build:
		cd ./RaccoonRaiders && $(CC) compile && $(CC) package

run:
		cd ./RaccoonRaiders && $(CC) compile && $(CC) package && cd ./target && java -classpath RaccoonRaiders-1.0-SNAPSHOT.jar com.group21.Launcher

test:
		cd ./RaccoonRaiders && $(CC) clean && $(CC) test
