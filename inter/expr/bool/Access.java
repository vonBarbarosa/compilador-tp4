package inter.expr.bool;

import inter.expr.Expr;
import inter.expr.Id;
import inter.expr.Op;
import lexer.Tag;
import lexer.Word;
import symbols.Type;

public class Access extends Op
{
  public Id array;
  
  public Expr index;
  
  /**
   * Construtor.
   * 
   * @param a Endereço do array.
   * @param i Index do array.
   * @param p Tipo de elementos do array.
   */
  public Access(Id a, Expr i, Type p)
  {
    super(new Word("[]",Tag.INDEX),p);
    array = a;
    index = i;
  }
  
  /**
   * gera código normal.
   */
  public Expr gen()
  {
    return new Access(array,index.reduce(),type);
  }
  
  /**
   * Gera código de desvio para acesso em arranjo.
   */
  public void jumping(int t, int f)
  {
    emitJumps(reduce().toString(), t, f);
  }
  
  /*
   * (non-Javadoc)
   * @see inter.Expr#toString()
   */
  public String toString()
  {
    return array.toString()+" [ "+index.toString()+" ]";
  }
}
