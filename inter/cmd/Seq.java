package inter.cmd;

public class Seq extends Stmt
{
  public Stmt stmt1;
  
  public Stmt stmt2;
  
  public Seq(Stmt s1, Stmt s2)
  {
    stmt1= s1;
    stmt2= s2;
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    if (stmt1 == Stmt.Null)     // Teste para comando nulo (evita rótulo).
    {
      stmt2.gen(b, a);
    }
    else if (stmt2 == Stmt.Null)// Teste para comando nulo (evita rótulo).
    {
      stmt1.gen(b, a);
    }
    else
    {
      int label = newLabel();
      stmt1.gen(b, label);
      emitLabel(label);
      stmt2.gen(label, a);
    }
  }
}
