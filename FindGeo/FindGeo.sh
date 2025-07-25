#!/bin/bash

if [ `uname` = "Linux" ]; then 
    java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
    if [[ "$(printf '%s\n' "17" "$java_version" | sort -V | head -n 1)" == "17" || "$(printf '%s\n' "17" "$java_version" | sort -V | head -n 1)" == $java_version ]]; then
	java -jar FindGeo-1.1.jar $@
    else
        echo "FindGeo require Java 17 or greater. Please install it and retry."
    fi
elif [ `uname` = "Darwin" ]; then
    java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
    if [[ "$(printf '%s\n' "17" "$java_version" | sort -V | head -n 1)" == "17" || "$(printf '%s\n' "17" "$java_version" | sort -V | head -n 1)" == $java_version ]]; then
	java -jar FindGeo-1.1.jar $@
    else
        echo "FindGeo require Java 17 or greater. Please install it and retry."
    fi
else
    echo "Operating System not supported."
fi
