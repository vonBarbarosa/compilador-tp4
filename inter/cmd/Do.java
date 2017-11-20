package inter.cmd;

import inter.expr.Expr;
import symbols.Type;

public class Do extends Stmt
{
  public Expr expr;
  
  public Stmt stmt;
  
  /**
   * Construtor.
   * Cria um nó com dois filhos nulos.
   */
  public Do()
  {
    expr = null;
    stmt = null;
  }
  
  /**
   * Define os filhos do nó do.
   * 
   * @param x Expressão.
   * @param s Estado.
   */
  public void init(Stmt s, Expr x)
  {
    expr = x;
    stmt = s;
    if (expr.type != Type.Bool)
    {
      expr.error("boolean required in do");
    }
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    after = a;
    int label = newLabel(); // Rótulo para expr.
    stmt.gen(b, label);
    emitLabel(label);
    expr.jumping(b, 0);
  }
}
