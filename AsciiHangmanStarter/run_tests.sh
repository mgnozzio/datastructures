#!/bin/bash
cd src
rm -f *.class;
javac Hangman.java Gallows.java Man.java;
for t in ../tests/*.txt; do
  java Hangman < $t > $t.out;
done;
cd ../tests/
for t in *.txt.out;
      do if [[ $(diff $t expected/$t) ]]; then echo $t; fi;
      rm $t
done > failed_tests.txt
x=$(wc -l < "failed_tests.txt")
if [[ $x -ne 0 ]]; then
    echo
    echo "Failing tests: ";
    cat failed_tests.txt;
    echo
    echo -n $x
    echo " / 20 tests failed."
    echo
else
    echo "All tests passed."
    echo
fi
rm failed_tests.txt
cd ..
rm -f src/*.class
