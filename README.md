# bowling-score-app
A command line program to read, parse and print the results of a bowling match.

# Compilation
Use the `mvn package` command to compile and generate the jar file.

## Requirements
* JDK 1.8
* Maven 3

# Tests
Use the `mvn tests` command to run the tests only.

# Usage
After compile and generate the jar file, use the `java -jar target/bowling-score.jar [file_path]` to run the program with a specific file.

If you don't pass the file_path, the program will try to read the files in the sample_case folder.
* sample_cases/all_fouls.txt
* sample_cases/all_zeros.txt
* sample_cases/empty.txt
* sample_cases/perfect_score.txt
* sample_cases/sample1.txt
* sample_cases/too_much_frames.txt