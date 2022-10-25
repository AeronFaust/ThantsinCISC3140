#! /usr/bin/bash
#Swann Thantsin
#CISC 3140
#Professor Katherine Chuang
#Due 10/26/2022

compileTarget=""
inputTarget=""

compile(){
    if [ "${compileTarget##*.}" = "java" ]
    then
        javac $compileTarget
    else
        echo "${compileTarget%.*} is not a proper Java program."
    fi
}

runProgram(){
if ["$inputTarget" = ""]
then
    java "${compileTarget%.*}"
else
    java "${compileTarget%.*}" < $inputTarget
fi
}

echo "Enter Java file to compile: "
read compileTarget

echo "Enter text file to input to program(leave empty if no file input redirection is needed): "
read inputTarget

if [ -f "${compileTarget%.*}.class" ]
then
{
    classFile="${compileTarget%.*}.class"
    classModified=$(date -r "$classFile" "+%s")
    javaModified=$(date -r "$compileTarget" "+%s")

    difference=$(($javaModified-$classModified))

    if [ $difference > 0 ]
    then
        rm $classFile
        compile
        runProgram
    else
        runProgram
    fi
}
else 
    compile
    runProgram
fi

