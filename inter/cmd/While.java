package inter.cmd;

import inter.expr.Expr;
import symbols.Type;

public class While extends Stmt
{
  public Expr expr;
  
  public Stmt stmt;
  
  /**
   * Construtor.
   * Cria um nó com dois filhos nulos.
   */
  public While()
  {
    expr = null;
    stmt = null;
  }
  
  /**
   * Define os filhos do nó while.
   * 
   * @param x Expressão.
   * @param s Estado.
   */
  public void init(Expr x, Stmt s)
  {
    expr = x;
    stmt = s;
    if (expr.type != Type.Bool)
    {
      expr.error("boolean required in while");
    }
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    after = a;              // Guarda rótulo a.
    expr.jumping(0, a);     
    int label = newLabel(); // Rótulo para comando.
    emitLabel(label);
    stmt.gen(label, b);
    emit("goto L"+b);
  }
}
