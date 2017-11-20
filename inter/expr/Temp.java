package inter.expr;

import lexer.Word;
import symbols.Type;

public class Temp extends Expr
{
  /**
   * Contador de temporários.
   */
  public static int count = 0;
  
  /**
   * Código do temporário.
   */
  public int number = 0;
  
  /**
   * Construtor.
   * 
   * @param p Tipo do temporário.
   */
  public Temp(Type p)
  {
    super(Word.temp,p);
    number = ++count;
  }
  
  /*
   * (non-Javadoc)
   * @see inter.Expr#toString()
   */
  public String toString()
  {
    return "t"+number;
  }
}
