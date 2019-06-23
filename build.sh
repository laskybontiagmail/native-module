#!/bin/sh

#export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/workarea/Eclipse/Study/workspaces/jni-maven/target/c++/

#mvn clean

#mkdir -p target/classes
#make

#mvn package install


rm -fvR target/*
mvn clean
mvn package install

