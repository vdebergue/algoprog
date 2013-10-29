.PHONY: export

TD=$(shell basename `pwd`)

all: src/*.java
	-mkdir -p bin/
	javac -d bin/ src/*

test: all
	java -cp bin/ -ea Test
	
clean:
	rm -rf bin/*

export:
	git archive --format tgz -o ../$(TD).tar.gz HEAD . --prefix=$(TD)/
