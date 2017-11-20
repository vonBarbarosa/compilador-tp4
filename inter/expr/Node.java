package inter.expr;

import lexer.Lexer;

public class Node
{
  /**
   * Número de labels do nó em questão.
   */
  public static int labels = 0;
  
  /**
   * Utilizado para guardar o número da linha fonte da construção do nó,
   * para o relato de erro.
   */
  public int lexline = 0;
  
  /**
   * Construtor.
   */
  public Node ()
  {
    lexline = Lexer.line;
  }
  
  /**
   * Lança uma mensagem de erro na linha atual, passada como parâmetro.
   * @param s Mensagem a ser exibida.
   */
  public void error (String s)
  {
    throw new Error("near line "+lexline+": "+s);
  }
  
  /**
   * Incrementa o número de labels.
   * @return Número de labels atualizado.
   */
  public int newLabel()
  {
    return ++labels;
  }
  
  /**
   * Imprime a label passado como parâmetro na tela.
   * @param i Label a ser impresso.
   */
  public void emitLabel(int i)
  {
    System.out.println("L"+i+":");
  }
  
  /**
   * Emite uma mensagem na tela, passada como parâmetro.
   * @param s Mensagem a ser emitida.
   */
  public void emit(String s)
  {
    System.out.println("\t"+s);
  }
}
