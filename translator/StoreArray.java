package translator;

public class StoreArray
{
  /**
   * Verifica se a quádrupla é um store em uma posição de array.
   * 
   * @param j posição na quádrupla.
   * @return resposta
   */
  public static boolean isStoreArray()
  {
    if (Translator.quad.length == 6)
    {
      if (Translator.quad[1].equals("[") && Translator.quad[3].equals("]") && Translator.quad[4].equals("="))
      {
        if (Translator.isId(0) && Translator.isId(2)) 
          bothId();
        else if (Translator.isId(0) && Translator.isIntConst(2)) 
          idAndIntConst();
        else if (Translator.isIntConst(0) && Translator.isId(2)) 
          intConstAndId();
        else if (Translator.isIntConst(0) && Translator.isIntConst(2))
          twoIntConsts();
        
        return true;
      }
    }
    return false;
  }
  
  /**
   * Ambos IDs
   */
  public static void bothId()
  {
    Translator.putInCodes(Translator.quad[0]); // Valor da primeira variável
    Translator.putInCodes(Translator.quad[2]); // Valor da segunda variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[0]); // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD index
    String passo3;
    String passo4;
    
    if (Translator.isId(5))
    {
      Translator.putInCodes(Translator.quad[5]); // Guarda o código da variável
      passo3 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[5]); // LOAD value
    }
    else
    {
      passo3 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[5]; // LOAD constant value
    }
    
    passo4 = (Translator.labelCounter++) + ": "+Opcode.AASTORE; // Coloca valor em a[index]
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
  }
  
  /**
   * Um ID e uma constante inteira
   */
  public static void idAndIntConst()
  {
    Translator.putInCodes(Translator.quad[0]); // Valor da primeira variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[0]); // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD index
    String passo3;
    String passo4;
    
    if (Translator.isId(5))
    {
      Translator.putInCodes(Translator.quad[5]); // Guarda o código da variável
      passo3 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[5]); // LOAD value
    }
    else
    {
      passo3 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[5]; // LOAD constant value
    }
    
    passo4 = (Translator.labelCounter++) + ": "+Opcode.AASTORE; // Coloca valor em a[index]
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
  }
  
  
  /**
   * Uma constante inteira e um ID.
   */
  public static void intConstAndId()
  {
    Translator.putInCodes(Translator.quad[2]); // Valor da segunda variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[0]; // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD index
    String passo3;
    String passo4;
    
    if (Translator.isId(5))
    {
      Translator.putInCodes(Translator.quad[5]); // Guarda o código da variável
      passo3 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[5]); // LOAD value
    }
    else
    {
      passo3 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[5]; // LOAD constant value
    }
    
    passo4 = (Translator.labelCounter++) + ": "+Opcode.AASTORE; // Coloca valor em a[index]
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
  }
  
  /**
   * Duas constantes inteiras.
   */
  
  public static void twoIntConsts()
  {
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[0]; // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD index
    String passo3;
    String passo4;
    
    if (Translator.isId(5))
    {
      Translator.putInCodes(Translator.quad[5]); // Guarda o código da variável
      passo3 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[5]); // LOAD value
    }
    else
    {
      passo3 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[5]; // LOAD constant value
    }
    
    passo4 = (Translator.labelCounter++) + ": "+Opcode.AASTORE; // Coloca valor em a[index]
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
  }
}
