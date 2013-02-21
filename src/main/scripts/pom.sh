#!/bin/sh

app_dir=`dirname $0`
java -cp ${app_dir}/lib/jar_pom_info-0.0.1.jar:${app_dir}/lib/jdom-2.0.2.jar org.mvnsearch.tools.JarPomViewer $1