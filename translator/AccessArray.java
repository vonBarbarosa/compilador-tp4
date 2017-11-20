package translator;

public class AccessArray
{
  /**
   * Verifica se a quádrupla é um acesso a uma posição array.
   * 
   * @param j posição na quádrupla.
   * @return resposta
   */
  public static boolean isAccessArray()
  {
    if (Translator.quad.length == 6)
    {
      if (Translator.quad[1].equals("=") && Translator.quad[3].equals("[") && Translator.quad[5].equals("]"))
      {
        if (Translator.isId(2) && Translator.isId(4)) 
          bothId();
        else if (Translator.isId(2) && Translator.isIntConst(4)) 
          idAndIntConst();
        else if (Translator.isIntConst(2) && Translator.isId(4)) 
          intConstAndId();
        else if (Translator.isIntConst(2) && Translator.isIntConst(4))
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
    Translator.putInCodes(Translator.quad[2]); // Valor da primeira variável
    Translator.putInCodes(Translator.quad[4]); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    Translator.putInValues(Translator.quad[0], 0);
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[4]); // LOAD index
    String passo3 = (Translator.labelCounter++) + ": "+Opcode.AALOAD; // Carrgea na pilha a[index]
    String passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na uma variável
    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  /**
   * Um ID e uma constante inteira
   */
  public static void idAndIntConst()
  {
    Translator.putInCodes(Translator.quad[2]); // Valor da primeira variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    Translator.putInValues(Translator.quad[0], 0);
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD array
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD CONST
    String passo3 = (Translator.labelCounter++) + ": "+Opcode.AALOAD; // Carrgea na pilha a[index]
    String passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na uma variável
    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  
  /**
   * Uma constante inteira e um ID.
   */
  public static void intConstAndId()
  {
    Translator.putInCodes(Translator.quad[4]); // Valor da primeira variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    Translator.putInValues(Translator.quad[0], 0);
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[4]); // LOAD array
    String passo3 = (Translator.labelCounter++) + ": "+Opcode.AALOAD; // Carrgea na pilha a[index]
    String passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na uma variável
    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  /**
   * Duas constantes inteiras.
   */
  
  public static void twoIntConsts()
  {
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    Translator.putInValues(Translator.quad[0], 0);
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD array
    String passo3 = (Translator.labelCounter++) + ": "+Opcode.AALOAD; // Carrgea na pilha a[index]
    String passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na uma variável
    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
}
