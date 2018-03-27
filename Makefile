# DamArrayApp program makefile
# Tlotliso Mapana
# 04 March 2018

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR = src
BINDIR = bin
DOCDIR = jdoc

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES = Dam.class\
	  BinaryTreeNode.class\
	  BinaryTree.class\
	  AVLTree.class\
	  BinarySearchTree.class\
	  DamAVLApp.class\
	  DamBSTApp.class
	  
CLASS_FILES = $(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

doc:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

runA:
	java -cp ./bin DamAVLApp

searchA:
	java -cp ./bin DamAVLApp ${ARGS}
	
runB:
	java -cp ./bin DamBSTApp

searchB:
	java -cp ./bin DamBSTApp ${ARGS}

clean:
	rm $(BINDIR)/*.class
	rm -Rf jdoc

