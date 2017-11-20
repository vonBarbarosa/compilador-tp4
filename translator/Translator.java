package translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Translator
{
  public static Scanner scan = new Scanner(System.in);
  
  /**
   * Armazena variÃ¡vel:valor inteiro.
   */
  public static HashMap<String,Integer> intValues = new HashMap<String,Integer>();
  
  /**
   * Armazena variÃ¡vel:valor float.
   */
  public static HashMap<String,Float> floatValues = new HashMap<String,Float>();
  
  /**
   * Armazena variÃ¡vel:cÃ³digo inteiro.
   */
  public static HashMap<String,Integer> varCode = new HashMap<String,Integer>();
  
  /**
   * Armazena instruÃ§Ã£o em uma posiÃ§Ã£o.
   */
  public static ArrayList<String> program = new ArrayList<String>();
  
  /**
   * Contador de labels, para que cada label tenha um cÃ³digo.
   */
  public static Integer labelCounter = 0;
  
  /**
   * Contador de variÃ¡veis, para que cada variÃ¡vel tenha um cÃ³digo.
   */
  public static Integer varCounter = 0;
  
  /**
   * QuÃ¡drupla.
   */
  public static String[] quad;
  
  /**
   * Verifica se a linha da quÃ¡drupla Ã© um label.
   * 
   * @return resposta
   */
  public static boolean isLabel ()
  {
    if (quad.length == 1)
    {
      int i = 0;
      StringBuilder s = new StringBuilder(quad[0]);
      boolean ans = s.charAt(i++) == 'L';
      while (i < s.length() && ans)
      {
        if (Character.isDigit(s.charAt(i)))
        {
          i++;
          ans = ans && true;
        }
        else if (i == s.length()-1 && s.charAt(i) == ':' && ans)
        {
          s.deleteCharAt(i);
          quad[0] = s.toString();
          return true;
        }
        else
          return false;
      }
      return false;
    }
    return false;
  }
  
  /**
   * Verifica se a posiÃ§Ã£o da linha da quÃ¡drupla Ã© uma variÃ¡vel temporÃ¡ria.
   * 
   * @param j posiÃ§Ã£o na quÃ¡drupla.
   * @return resposta
   */
  public static boolean isTemp(int j)
  {
    String s = quad[j];
    int i = 0;
    if (s.charAt(i) == 't')
    {
      boolean ans = true;
      while (i < s.length() && ans)
      {
        ans = ans && Character.isDigit(s.charAt(i++));
      }
      return ans;
    }
    return false;
  }
  
  /**
   * Verifica se a posiÃ§Ã£o da linha da quÃ¡drupla Ã© uma constante inteira.
   * 
   * @param j posiÃ§Ã£o na quÃ¡drupla.
   * @return resposta
   */
  public static boolean isIntConst(int j)
  {
    String s = quad[j];
    return s.matches("-?\\d+");
  }
  
  /**
   * Verifica se a posiÃ§Ã£o da linha da quÃ¡drupla Ã© uma constante float.
   * 
   * @param j posiÃ§Ã£o na quÃ¡drupla.
   * @return resposta
   */
  public static boolean isFloatConst(int j)
  {
    String s = quad[j];
    return s.matches("-?\\d+(\\.\\d+)?");
  }
  
  /**
   * Verifica se a posiÃ§Ã£o da quÃ¡drupla Ã© uma variÃ¡vel id.
   * 
   * @param j posiÃ§Ã£o na quÃ¡drupla.
   * @return resposta
   */
  public static boolean isId(int j)
  {
    String s = quad[j];
    int i = 0;
    if (Character.isLetter(s.charAt(i)))
    {
      boolean ans = true;
      while (i < s.length() && ans)
      {
        ans = ans && Character.isLetterOrDigit(s.charAt(i++));
      }
      return ans;
    }
    return false;
  }
  
  /**
   * LÃª a prÃ³xima linha e a quebra em quÃ¡drupla.
   */
  public static void read()
  {
    String q = scan.nextLine();
    q.trim();
    quad = q.split(" ");
  }
  
  /**
   * Printa o programa final.
   */
  public static void print ()
  {
    for(int i = 0; i < program.size(); i++)
    {
      System.out.println(program.get(i));
    }
  }
  
  /**
   * Guarda variÃ¡veis e seus respectivos valores inteiros.
   * 
   * @param s Nome da variÃ¡vel.
   * @param x Valor inteiro.
   */
  public static void putInValues (String s, int x)
  {
    if (intValues.get(s) == null)
    {
      intValues.put(s, x);
    }
  }
  
  /**
   * Guarda variÃ¡veis e seus respectivos valores floats.
   * 
   * @param s Nome da variÃ¡vel.
   * @param x Valor float.
   */
  public static void putInValues (String s, float x)
  {
    if (floatValues.get(s) == null)
    {
      floatValues.put(s, x);
    }
  }
  
  /**
   * Guarda variÃ¡veis e seus respectivos cÃ³digos.
   * 
   * @param s Nome da variÃ¡vel.
   */
  public static void putInCodes (String s)
  {
    if (varCode.get(s) == null)
    {
      varCode.put(s, varCounter++);
    }
  }
  
  /**
   * Retorna o valor da variÃ¡vel.
   * 
   * @param s Nome da variÃ¡vel.
   * @return valor da variÃ¡vel.
   */
  public static Object getFromValues (String s)
  {
    if (intValues.get(s) != null)
    {
      return intValues.get(s);
    }
    return floatValues.get(s);
  }
  
  /**
   * Traduz.
   */
  public static void translate ()
  {
    read();
    for (;;read())
    {
      if(quad[0].equals("EOF"))
      {
        break;
      }
      if(isLabel())
      {
        varCode.put(quad[0],labelCounter);
        program.add(labelCounter+": ");
      }
      else if(Add.isAdd());
      else if(Sub.isSub());
      else if(Mul.isMul());
      else if(Div.isDiv());
      else if(AccessArray.isAccessArray());
      else if(StoreArray.isStoreArray());
      else if(Jump.isJump());
      else if(Branch.isBranch());
      else if(FalseBranch.isFalseBranch());
      
      labelCounter++;
    }
  }
  
  public static void main (String[] args)
  {
    translate();
    print();
  }
}
