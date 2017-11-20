package inter.expr.bool;

import inter.expr.Expr;
import lexer.Num;
import lexer.Token;
import lexer.Word;
import symbols.Type;

public class Constant extends Expr
{
  public static final Constant True = new Constant(Word.True, Type.Bool);
  
  public static final Constant False = new Constant(Word.False, Type.Bool);
  
  /**
   * Construtor.
   * Constrói uma folha da árvore de sintaxe com o rótulo tok e tipo p.
   * 
   * @param tok Token.
   * @param p Tipo.
   */
  public Constant(Token tok, Type p)
  {
    super(tok,p);
  }
  
  /**
   * Construtor.
   * Por conveniência, o construtor é sobrecarregado para criar um 
   * objeto constante a partir de um inteiro.
   * 
   * @param i Constante inteira.
   */
  public Constant(int i)
  {
    super(new Num(i), Type.Int);
  }
  
  /**
   * O código de desvio para uma expressão booleana B é gerado por 
   * esse método, que recebe dois parâmetros t e f, chamados 
   * respectivamente de saídas verdadeiras e falsas de B. Desviamos 
   * para t se B for avaliado como verdadeiro e um desvio para F se 
   * B for avaliado como falso. por convenção, 0 significa que o 
   * controle passa por B em direção a próxima instrução após o código 
   * de B. 
   * 
   * @param t True.
   * @param f False.
   */
  public void jumping(int t, int f)
  {
    if (this == True && t != 0)
    {
      emit("goto L"+t);
    }
    else if (this == False && f != 0)
    {
      emit("goto L"+f);
    }
  }
}
