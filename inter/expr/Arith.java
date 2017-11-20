package inter.expr;

import lexer.Token;
import symbols.Type;

public class Arith extends Op
{
  public Expr expr1;
  
  public Expr expr2;
  
  /**
   * Construtor.
   * 
   * @param tok Operador.
   * @param x1 Primeira expressão.
   * @param x2 Segunda expressão.
   */
  public Arith (Token tok, Expr x1, Expr x2)
  {
    super(tok,null);
    expr1 = x2;
    expr2 = x2;
    type = Type.max(expr1.type, expr2.type);
    if (type == null)
    {
      error("type error");
    }
  }
  
  /**
   * Constrói o lado direito de uma função de três endereços, 
   * reduzindo as subexpressões para endereços e aplicando o 
   * operador aos endereços.
   * 
   * @return Um novo nó Arith com um operador e dois endereços.
   */
  public Expr gen()
  {
    return new Arith(op,expr1.reduce(),expr2.reduce());
  }
  
  /*
   * (non-Javadoc)
   * @see inter.Expr#toString()
   */
  public String toString()
  {
    return expr1.toString()+" "+op.toString()+" "+expr2.toString();
  }
}
