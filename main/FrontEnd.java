package main;

import java.io.IOException;

import lexer.Lexer;
import parser.Parser;

public class FrontEnd
{
  public static void main (String[] args) throws IOException
  {
    Lexer lex = new Lexer();
    Parser parse = new Parser(lex);
    parse.program();
    System.out.print("EOF");
    System.out.write('\n');
  }
}
