package inter.cmd;

import inter.expr.Expr;
import symbols.Type;


public class Else extends Stmt
{
  public Expr expr;
  
  public Stmt stmt1;
  
  public Stmt stmt2;
  
  /**
   * Construtor.
   * 
   * @param x Expressão da condição if.
   * @param s1 Estado 1.
   * @param s2 Estado 2.
   */
  public Else(Expr x, Stmt s1, Stmt s2)
  {
    expr = x;
    stmt1 = s1;
    stmt2 = s2;
    if (expr.type != Type.Bool)
    {
      expr.error("boolean required in if");
    }
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    int label1 = newLabel();  // label1 para stmt1.
    int label2 = newLabel();  // label2 para stmt2.
    expr.jumping(0, label2);  // Segue para stmt1 se expr for true.
    emitLabel(label1);
    stmt1.gen(label1, a);
    emit("goto L"+a);
    emitLabel(label2);
    stmt1.gen(label2, a);
  }
}
