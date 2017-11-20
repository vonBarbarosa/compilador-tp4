package inter.cmd;

public class Break extends Stmt
{
  public Stmt stmt;
  
  /**
   * Construtor.
   */
  public Break()
  {
    if(Stmt.Enclosing == null)
    {
      error("unenclosed break");
    }
    stmt = Stmt.Enclosing;
  }
  
  /*
   * (non-Javadoc)
   * @see inter.cmd.Stmt#gen(int, int)
   */
  public void gen(int b, int a)
  {
    emit("goto L"+stmt.after);
  }
}
