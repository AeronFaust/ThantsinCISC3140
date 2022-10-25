#! /usr/bin/awk -f
#AWK Program 5: Getting the number of commits per year from 2008-2021


BEGIN{ 
        print "Starting to read" 
        FS=","
        count = 0
    }

{ 
    #filters string so that it only reads strings containing provided regex
    if ($4 ~ /^fix/){
    	countFix++
    }
    #filters string again so that it only reads strings containing provided regex
    if ($4 ~ /^bug/){
    	countBug++
    }
}

END{ 
        print "Finished reading"
        for (i = 0 ; i < 10; i++) print "."  #padding
        print "The occurences of the word \"bug\" in a commit message : " countBug
        print "The occurences of the word \"fix\" in a commit message : " countFix
        
    }	