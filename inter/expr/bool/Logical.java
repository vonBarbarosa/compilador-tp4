package inter.expr.bool;

import inter.expr.Expr;
import inter.expr.Temp;
import lexer.Token;
import symbols.Type;

public class Logical extends Expr
{
  /**
   * Expressão booleana 1.
   */
  public Expr expr1;
  
  /**
   * Expressão booleana 2.
   */
  public Expr expr2;
  
  /**
   * Construtor.
   * 
   * @param tok Operador lógico.
   * @param x1 Primeiro operando lógico.
   * @param x2 Segundo operando lógico.
   */
  public Logical (Token tok, Expr x1, Expr x2)
  {
    super(tok,null);
    expr1 = x1;
    expr2 = x2;
    type = check(expr1.type, expr2.type);
    if (type == null)
    {
      error("type error");
    }
  }
  
  /**
   * Garante que ambas as expressões são booleanas.
   * 
   * @param p1 Tipo da expressão 1.
   * @param p2 Tipo da expressão 2.
   * @return Resposta.
   */
  public Type check (Type p1, Type p2)
  {
    if (p1 == Type.Bool && p2 == Type.Bool)
    {
      return Type.Bool;
    }
    else
    {
      return null;
    }
  }
  
  /*
   * (non-Javadoc)
   * @see inter.Expr#gen()
   */
  public Expr gen()
  {
    int f = newLabel();
    int a = newLabel();
    Temp temp = new Temp(type);
    this.jumping(0, f);
    emit(temp.toString()+" = true");
    emit("goto L"+a);
    emitLabel(f);
    emit(temp.toString()+" = false");
    emitLabel(a);
    return temp;
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
