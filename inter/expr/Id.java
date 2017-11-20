package inter.expr;

import lexer.Word;
import symbols.Type;

public class Id extends Expr
{
  /**
   * Endereço relativo do identificador.
   */
  public int offset;
  
  /**
   * Construtor.
   * 
   * @param id Identificador.
   * @param p Tipo.
   * @param b Offset.
   */
  public Id(Word id, Type p, int b)
  {
    super(id,p);
    offset = b;
  }
}
