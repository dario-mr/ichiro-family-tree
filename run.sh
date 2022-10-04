#! /bin/bash
mvn -B clean package
java -jar target/ichiro-family-tree-0.0.5.jar &