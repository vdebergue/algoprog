.PHONY: export

CHANGES=$(shell git diff-index --quiet HEAD; echo $$?)

TD=$(shell basename `pwd`)

all: src/*.java
	-mkdir -p bin/
	javac -d bin/ src/*.java

test: all
	java -cp bin/ -ea Test
	
clean:
	rm -rf bin/*

export: rungitcommit$(CHANGES)
	-mkdir -p bin/
	git archive --format tgz -o ../$(TD).tar.gz HEAD . --prefix=$(TD)/

rungitcommit0:
