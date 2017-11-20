package inter.expr.bool;

import inter.expr.Expr;
import lexer.Token;
import symbols.Array;
import symbols.Type;

public class Rel extends Logical
{
  /**
   * Construtor.
   * 
   * @param tok Operador lógico.
   * @param x1 Expressão booleana 1.
   * @param x2 Expressão booleana 2.
   */
  public Rel (Token tok, Expr x1, Expr x2)
  {
    super(tok,x1,x2);
  }
  
  /**
   * Verifica se os dois operandos têm o mesmo tipo e se não 
   * são arranjos.
   * 
   * @param p1 Tipo do operando 1.
   * @param p2 Tipo do operando 2.
   * @return Resposta.
   */
  public Type check (Type p1, Type p2)
  {
    if (p1 instanceof Array || p2 instanceof Array)
    {
      return null;
    }
    else if (p1 == p2)
    {
      return Type.Bool;
    }
    else
    {
      return null;
    }
  }
  
  /**
   * Gera código de desvio para expressões de relações.
   * >, <, >=, <=, ==, !=
   * 
   * @param t True.
   * @param f False.
   */
  public void jumping(int t, int f)
  {
    Expr a = expr1.reduce();
    Expr b = expr2.reduce();
    String test = a.toString()+" "+op.toString()+" "+b.toString();
    emitJumps(test, t, f);
  }
}
