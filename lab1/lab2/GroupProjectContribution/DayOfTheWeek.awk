#! /usr/bin/awk -f
#AWK Program 4: Getting the number of commits according to the day of the week

BEGIN{ 
        print "Starting to read" 
        FS=","
    }

{ 
    split($3,data," ")
    #filters string so that it only reads strings containing provided regex
    #and assigns them to an array entry and increments said entry. 
    if (data[1] ~ /Sun|Mon|Tue|Wed|Thu|Fri|Sat/){
        count[data[1]]++
    }
}

END{ 
        print "Finished reading"
        for (i = 0 ; i < 10; i++) print "."  #padding
        print "Days of the Week: Commits"
        print "Sun             : " count["Sun"]
        print "Mon             : " count["Mon"]
        print "Tue             : " count["Tue"]
        print "Wed             : " count["Wed"]
        print "Thu             : " count["Thu"]
        print "Fri             : " count["Fri"]
        print "Sat             : " count["Sat"]
    }	