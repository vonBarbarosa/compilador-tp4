package inter.expr.bool;

import inter.expr.Expr;
import lexer.Token;

public class And extends Logical
{
  /**
   * Construtor.
   * 
   * @param tok Operador lógico.
   * @param x1 Expressão booleana 1.
   * @param x2 Expressão booleana 2.
   */
  public And (Token tok, Expr x1, Expr x2)
  {
    super(tok,x1,x2);
  }
  
  /**
   * Gera código de desvio para a expressão boleana B = B1 && B2.
   * 
   * @param t True.
   * @param f False.
   */
  public void jumping(int t, int f)
  {
    int label = f != 0 ? f : newLabel();
    expr1.jumping(0, label);
    expr2.jumping(t, f);
    if (f == 0)
    {
      emitLabel(label);
    }
  }
}
