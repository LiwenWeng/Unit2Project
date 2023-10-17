#!/bin/bash

# Get the current directory
CURRENT_DIR=$(dirname "${BASH_SOURCE[0]}")

# Navigate to the script's directory
cd "$CURRENT_DIR" || exit

# Compile all Java files in the directory
for file in *.java; do
    if [ -f "$file" ]; then
        javac "$file"
        # Check if the compilation was successful
        if [ $? -eq 0 ]; then
            echo "Compilation of $file successful."
        else
            echo "Compilation of $file failed."
        fi
    fi
done

java Main.java