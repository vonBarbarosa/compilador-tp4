package symbols;

import lexer.Tag;

public class Array extends Type
{
  /**
   * Arranjo *of* type
   */
  public Type of;
  
  /**
   * Número de elementos.
   */
  public int size = 1;
  
  /**
   * Construtor
   * 
   * @param sz - Tamanho do array
   * @param p - Tipo do array
   */
  public Array (int sz, Type p)
  {
    super("[]", Tag.INDEX, sz*p.width);
    size = sz;
    of = p;
  }
  
  public String toString ()
  {
    return "["+size+"] "+of.toString();
  }
}
