package inter.expr;

import lexer.Token;
import symbols.Type;

public class Unary extends Op
{
  /**
   * Expressão unária.
   */
  public Expr expr;
  
  /**
   * Construtor.
   * 
   * @param tok Operador.
   * @param x Expressão unária.
   */
  public Unary (Token tok, Expr x)
  {
    super(tok,null);
    expr = x;
    type = Type.max(Type.Int, expr.type);
    if (type == null)
    {
      error("type error");  
    }
  }
  
  /**
   * Constrói o lado direito de uma função de três endereços, 
   * reduzindo a subexpressão unária para um endereço e aplicando o 
   * operador ao endereço.
   * 
   * @return Um novo nó Unary com um operador e um endereços.
   */
  public Expr gen()
  {
    return new Unary(op,expr.reduce());
  }
  
  /*
   * (non-Javadoc)
   * @see inter.Expr#toString()
   */
  public String toString ()
  {
    return op.toString()+" "+expr.toString();
  }
}
