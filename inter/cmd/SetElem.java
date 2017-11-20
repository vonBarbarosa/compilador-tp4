package inter.cmd;

import inter.expr.Expr;
import inter.expr.Id;
import inter.expr.bool.Access;
import symbols.Array;
import symbols.Type;

public class SetElem extends Stmt
{
  public Id array;
  
  public Expr index;
  
  public Expr expr;
  
  public SetElem(Access x, Expr y)
  {
    array = x.array;
    index = x.index;
    expr = y;
    
    if(check(x.type,expr.type) == null)
    {
      error("type error");
    }
  }
  
  /**
   * Verifica se dois tipos são iguais.
   * 
   * @param p1 Tipo 1.
   * @param p2 Tipo 2.
   * @return Resposta.
   */
  public Type check(Type p1, Type p2)
  {
    if(p1 instanceof Array || p2 instanceof Array)
    {
      return null;
    }
    else if(Type.numeric(p1) && Type.numeric(p2))
    {
      return p2;
    }
    else if(p1 == Type.Bool && p2 == Type.Bool)
    {
      return p2;
    }
    else
    {
      return null;
    }
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    String s1 = index.reduce().toString();
    String s2 = expr.reduce().toString();
    emit(array.toString()+ " [ "+s1+" ] = "+s2);
  }
}
