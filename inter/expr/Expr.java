package inter.expr;

import lexer.Token;
import symbols.Type;

public class Expr extends Node
{
  /**
   * Operador da expressão.
   */
  public Token op;
  
  /**
   * Tipo da expressão.
   */
  public Type type;
  
  /**
   * Construtor.
   * 
   * @param tok Operador da expressão.
   * @param p Tipo da expressão.
   */
  public Expr (Token tok, Type p)
  {
    op = tok;
    type = p;
  }
  
  /**
   * Retorna um termo que pode caber no lado direito de 
   * um código de três endereços.
   * 
   * @return Termo.
   */
  public Expr gen()
  {
    return this;
  }
  
  /**
   * Calcula ou reduz uma expressão em um endereço único, 
   * retornando uma ocnstante, um identificador, ou um 
   * nome temporário.
   * 
   * @return Expressão reduzida.
   */
  public Expr reduce()
  {
    return this;
  }
  
  /**
   * Gera um código de desvio para expressõs booleanas.
   * 
   * @param t True
   * @param f False
   */
  public void jumping(int t, int f)
  {
    emitJumps(toString(), t,f);
  }
  
  public void emitJumps(String test, int t, int f)
  {
    if (t != 0 && f != 0)
    {
      emit("if "+test+" goto L"+t);
      emit("goto L"+f);
    }
    else if (t != 0)
    {
      emit("if "+test+" goto L"+t);
    }
    else if(f != 0)
    {
      emit("iffalse "+test+" goto L"+f);
    }
    else ;
  }
  
  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  public String toString()
  {
    return op.toString();
  }
}
