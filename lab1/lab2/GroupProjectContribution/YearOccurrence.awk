#! /usr/bin/awk -f
#AWK Program 1: Getting the number of commits per email

BEGIN{ 
        print "Starting to read" 
        #separates csv into columns, separation denoted by "," character
        FS=","
    }

{ 
    #splits column 3 into sub-strings, separation denoted by " " character
    #stored in array named data
    split($3,data," ")

    #data[5] is the 5th sub-string of the 3rd column, which contains the year value
    #this if statement compares said sub-string with a regex that takes (1|2)(0|9)(NUM)(NUM)
    #and assigns them to an array entry and increments said entry. 
    #If the value is greater than 2007 and less than 2022 it is entered into count
    if(data[5] ~ /^[12][09][0-9]{2}$/ && data[5] > 2007 && data[5] < 2022){
        count[data[5]]++
    }
}

END{ 
        print "Finished reading"
        for (i = 0 ; i < 10; i++) print "."  #padding
        print "Year: Occurrence"
        for (date in count) print date ": " count[date] #prints date and occurance
    }