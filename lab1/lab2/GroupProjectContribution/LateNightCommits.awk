#! /usr/bin/awk -f
#AWK Program 3: Getting the number of commits made between midnight and 9AM

BEGIN{ 
        print "Starting to read" 
        #separates csv into columns, separation denoted by "," character
        FS=","
        counter = 0 #counter initialization
        counter2= 0 #counter2 initialization
    }

#Skips over NULL values, removing comments
(length($3)>0){ 
    #splits column 3 into sub-strings, separation denoted by " " character
    #stored in array named data
    split($3,data," ")
    #further spits the 4th data-substring each row, separation denoted by ":"
    #character stoored in array named hours
    split(data[4], hours,":")

    #data[4] is the 4th sub-string of the 3rd column, which contains the time value
    #it is further split and hours[1] is the 1st sub-string of data[4], which
    #contains the hour value.If the value is greater than or equal to 0 and less
    #than 9 it increments the counter. Else, it increments the counter2

    if(data[4] ~ /^[0-9]{2}:[0-9]{2}:[0-9]{2}$/){
        if (hours[1] >= 0 && hours[1] < 9) counter++	
        else{
            counter2 ++
        } 

    }   
}

END{ 
        print "Finished reading" 
        for (i = 0 ; i < 10; i++) print "."  #padding
        print "The amount commits made overnight:                  " counter
        print "The amount commits made during the rest of the day: " counter2
    }