sources = $(wildcard src/*.java)

all: build

build: $(sources)
	javac -sourcepath src $(sources) -d out

run: build
	java -classpath out Main

clean:
	rm -rf out/*.class