build: compile test

compile:
	javac lexer/*.java
	javac symbols/*.java
	javac inter/cmd/*.java
	javac inter/expr/*.java
	javac parser/*.java
	javac main/*.java
	javac translator/*.java

test:
	mkdir out
	@for i in `(cd tests; ls *.t | sed -e 's/.t$$//')`;\
		do echo $$i.t;\
		java main.FrontEnd <tests/$$i.t >out/$$i.out;\
	done

	@for x in `(cd out; ls *.out | sed -e 's/.out$$//')`;\
		do echo $$x.out;\
		java translator.Translator <out/$$x.out >out/$$x.bit;\
	done


clean:
	(cd lexer; rm *.class)
	(cd symbols; rm *.class)
	(cd inter/cmd; rm *.class)
	(cd inter/expr; rm *.class)
	(cd inter/expr/bool; rm *.class)	
	(cd parser; rm *.class)
	(cd main; rm *.class)
	(cd translator; rm *.class)
	(rm -r out)
