CC=gcc
#CFLAGS=-c -Wall -fPIC -I/usr/lib/jvm/java-7-openjdk-amd64/include
CFLAGS=-c -Wall -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin
LDFLAGS=-fPIC -shared

SOURCES_DIR=src/main/c++
OBJECTS_DIR=target/c++
EXECUTABLE=target/classes/liblasky.so

SOURCES=$(shell find '$(SOURCES_DIR)' -type f -name '*.cpp')
#SOURCES=$(shell find '$(SOURCES_DIR)' -type f -name '*.c')
OBJECTS=$(SOURCES:$(SOURCES_DIR)/%.cpp=$(OBJECTS_DIR)/%.o)

all: $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

$(OBJECTS): $(SOURCES)
	mkdir -p $(OBJECTS_DIR)
	$(CC) $(CFLAGS) $< -o $@

clean:
	rm -rf $(OBJECTS_DIR) $(EXECUTABLE)
