package inter.expr;

import lexer.Token;
import symbols.Type;

public class Op extends Expr
{
  /**
   * Construtor.
   * 
   * @param tok Operador.
   * @param p Tipo.
   */
  public Op(Token tok, Type p)
  {
    super(tok,p);
  }
  
  /**
   * Para cada caso (operadores aritméticos/operadores unários/acesso em vetores), 
   * chama gen para gerar um termo, emite uma função para atribuir o termo a um 
   * novo nome temporário e retorna o temporário.
   * 
   * @return t Temporário.
   */
  public Expr reduce ()
  {
    Expr x = gen();
    Temp t = new Temp(type);
    emit(t.toString()+" = "+x.toString());
    return t;
  }
}
