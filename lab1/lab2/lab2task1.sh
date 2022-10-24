#! /usr/bin/bash
#Swann Thantsin
#CISC 3140
#Professor Katherine Chuang
#Due 10/26/2022

#initialized dates
now=`date +%Y-%m-%d`

lab1="2022-09-28"
lab2="2022-10-26"
lab3="2022-11-23"
lab4="2022-12-07"

quiz1="2022-09-14"
quiz2="2022-09-28"
quiz3="2022-10-26"
quiz4="2022-11-16"
quiz5="2022-12-07"

finals="2022-12-19"

setnow=$now
setcomp=$now

#date user input
echo "Enter date(format: MM/DD/YYYY or MM-DD or leave empty for current date): "
read datetext

isDate=false

#proper current date check
while ! $isDate
do
    #MM/DD/YYYY regex
    if [[ $datetext =~ ^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$ ]]
    then
        IFS="/" read monthtext daytext yeartext<<< "$datetext"
        setnow="$yeartext-$monthtext-$daytext"
        isDate=true
    #MM-DD regex
    elif [[ $datetext =~ ^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$ ]]
    then 
        setnow="$(date -d "$now" '+%Y')-$datetext"
        isDate=true
    elif ["$datetext" = ""]
    then
        isDate=true
    else
        echo "Please enter a valid date format (MM/DD/YYYY or MM-DD or leave empty for current date): "
        read datetext
    fi
done
choiceinput=false

#proper date to compare check
while ! $choiceinput
do
    echo "Please choose a date to compare to: "
    echo "1. Assignment Due Dates."
    echo "2. Quiz Dates."
    echo "3. Finals Date."
    echo "4. Custom Date."
    read dateChoice

    #switch to choose/set date
    case $dateChoice in
    1)
        properDateChoice=false
        while ! $properDateChoice
        do
            echo "Please choose an Assignment Due Date"
            echo "1. Lab1 $lab1"
            echo "2. Lab2 $lab2"
            echo "3. Lab3 $lab3"
            echo "4. Lab4 $lab4"
            read dateChoice
            
            case $dateChoice in
            1)
                setcomp=$lab1
                properDateChoice=true
            ;;
            2)
                setcomp=$lab2
                properDateChoice=true
            ;;
            3)
                setcomp=$lab3
                properDateChoice=true
            ;;
            4)
                setcomp=$lab4
                properDateChoice=true
            ;;
            *)
                echo "$dateChoice is not a valid option."
            ;;
        esac
        done
        choiceinput=true
    ;;
    2)        
        properDateChoice=false
        while ! $properDateChoice
        do
            echo "Please choose a Quiz Date"
            echo "1. Quiz1 $quiz1"
            echo "2. Quiz2 $quiz2"
            echo "3. Quiz3 $quiz3"
            echo "4. Quiz4 $quiz4"
            echo "5. Quiz5 $quiz5"
            read dateChoice
            
            case $dateChoice in
            1)
                setcomp=$quiz1
                properDateChoice=true
            ;;
            2)
                setcomp=$quiz2
                properDateChoice=true
            ;;
            3)
                setcomp=$quiz3
                properDateChoice=true
            ;;
            4)
                setcomp=$quiz4
                properDateChoice=true
            ;;
            5)
                setcomp=$quiz5
                properDateChoice=true
            ;;
            *)
                echo "$dateChoice is not a valid option."
            ;;
        esac
        done
        choiceinput=true
    ;;
    3)
        setcomp=$finals
        choiceinput=true
    ;;
    4)
        echo "Please enter a date to compare to(MM/DD/YYYY or MM-DD or leave empty for current date): "
        read datetext
        isDate=false
        while ! $isDate
        do
            if [[ $datetext =~ ^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$ ]]
            then
                IFS="/" read monthtext daytext yeartext<<< "$datetext"
                setcomp="$yeartext-$monthtext-$daytext"
                isDate=true
            elif [[ $datetext =~ ^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$ ]]
            then 
                setcomp="$(date -d "$now" '+%Y')-$datetext"
                endDate=$(date -d "$setcomp" '+%s')
                currDate=$(date -d "$now" '+%s')
                difference=$(($endDate-$currDate))
                if [ $difference -lt "0" ]
                then
                    setcomp=$(date +%Y-%m-%d -d "$setcomp + 1 year")
                fi
                isDate=true
            else
                echo "Please enter a valid date format (MM/DD/YYYY or MM-DD or leave empty for current date): "
                read datetext
            fi
        done
        choiceinput=true
    ;;
    *)
        echo "$dateChoice is not a valid option."
    ;;
esac
done

#calculating difference in days between two dates
dateVal=$(date --date="$setnow" '+%s')
compVal=$(date --date="$setcomp" '+%s')

diff=$(( ($compVal - $dateVal) / (60*60*24) ))

#finalized output
echo "Current Date:    $setnow"
echo "Date to Compare: $setcomp"

if [ $diff -lt "0" ]
then
    echo "The date has passed."
else
    echo  "Days between $setnow and $setcomp is $diff days"
fi
