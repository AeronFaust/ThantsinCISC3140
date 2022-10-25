AWK = awk
AFLAGS = -f
FILE = 

.SUFFIXES: .awk
.awk:
	$(AWK) $(AFLAGS) $*.awk

CLASSES = \
	DayOfTheWeek.awk \
	FixBugFilter.awk \
	LateNightCOmmits.awk \
	YearOccurrence.awk 

run: classes
	$(AWK) $(AFLAGS) $(CLASSES) $(FILE)