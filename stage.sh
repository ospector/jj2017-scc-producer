#! /bin/sh
if [ $# -eq 0 ]; then
    echo "Please input the stage you want to revert to"
    exit 1
fi

if [ -z $(git tag | grep stage${1}) ]; then
    echo "No tag named stage${1}"
    exit 1
fi

rm -rf target
git clean -fd
git checkout tags/stage${1}