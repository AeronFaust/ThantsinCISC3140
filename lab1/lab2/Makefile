JC = javac
JCR = java
FILE = test2.txt

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = lab2task1.java

TARGET = lab2task1

run: classes
	$(JCR) $(TARGET) < $(FILE)

default: classes

classes: $(CLASSES:.java=.class)

clean: $(RM) *.class