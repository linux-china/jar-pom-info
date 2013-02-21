#!/bin/sh

app_dir=`dirname $0`
java -jar ${app_dir}/jar_pom_info-0.0.1.jar:${app_dir}/jdom-2.0.2.jar $1