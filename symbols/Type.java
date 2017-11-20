package symbols;

import lexer.Tag;
import lexer.Word;

public class Type extends Word
{
  public static final Type Int = new Type("int", Tag.BASIC , 4);
  
  public static final Type Float = new Type("float", Tag.BASIC , 8);
  
  public static final Type Char = new Type("char", Tag.BASIC , 1);
  
  public static final Type Bool = new Type("bool", Tag.BASIC , 1);
  
  /**
   * Usado para alocação de memória.
   */
  public int width;
  
  /**
   * Construtor
   * 
   * @param s - lexema
   * @param tag - tag
   * @param w - width
   */
  public Type (String s, int tag, int w)
  {
    super(s, tag);
    width = w;
  }
  
  /**
   * Verifica se um tipo é numérico. Útil para conversões de tipo.
   * 
   * @param p - tipo
   * @return Se o tipo é numérico ou não.
   */
  public static boolean numeric(Type p)
  {
    if (p == Type.Char || p == Type.Int || p == Type.Float)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  /**
   * Verifica semelhança entre tipos. Útil para conversões de tipo.
   * As conversões são permitidas apenas entre tipos numéricos.
   * Quando o operador aritmético é aplicado a dois tipos numéricos,
   * o resultado é o 'max' dos dois tipos.
   * 
   * @param p1 - Tipo 1
   * @param p2 - Tipo 2
   * @return Semelhança entre tipos.
   */
  public static Type max(Type p1, Type p2)
  {
    if (!numeric(p1) || !numeric(p2))
    {
      return null;
    }
    else if (p1 == Type.Float || p2 == Type.Float)
    {
      return Type.Float;
    }
    else if (p1 == Type.Int || p2 == Type.Int)
    {
      return Type.Int;
    }
    else
    {
      return Type.Char;
    }
  }
}
