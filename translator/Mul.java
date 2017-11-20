package translator;

public class Mul
{
  /**
   * Verifica se a linha da quádrupla é uma operação de multiplicação.
   * 
   * @return resposta
   */
  public static boolean isMul()
  {
    if (Translator.quad.length == 5)
    {
      if (Translator.quad[1].equals("=") && Translator.quad[3].equals("*"))
      {
        if (Translator.isId(2) && Translator.isId(4)) 
          bothId();
        else if (Translator.isId(2) && Translator.isIntConst(4)) 
          idAndIntConst();
        else if (Translator.isId(2) && Translator.isFloatConst(4))
          idAndFloatConst();
        else if (Translator.isIntConst(2) && Translator.isId(4)) 
          intConstAndId();
        else if (Translator.isFloatConst(2) && Translator.isId(4))
          floatConstAndId();
        else if (Translator.isIntConst(2) && Translator.isIntConst(4))
          twoIntConsts();
        else if (Translator.isFloatConst(2) && Translator.isFloatConst(4))
          twoFloatConsts();

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
    Object x1 = Translator.getFromValues(Translator.quad[2]); // Valor da primeira variável
    Object x2 = Translator.getFromValues(Translator.quad[4]); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD A
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[4]); // LOAD B
    String passo3;
    String passo4;
    
    if (x1 instanceof Integer && x2 instanceof Integer)
    {
      // Resultado da soma na variável inteira
      Integer mul = Integer.parseInt(x1.toString())*Integer.parseInt(x2.toString());
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.IMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }
    else
    {
      // Resultado da soma na variável float
      Float mul = Float.parseFloat(x1.toString())*Float.parseFloat(x2.toString());
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }

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
    Object x1 = Translator.getFromValues(Translator.quad[2]); // Valor da primeira variável
    Integer x2 = Integer.parseInt(Translator.quad[4].toString()); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD A
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD CONST
    String passo3;
    String passo4;
    
    if (x1 instanceof Integer)
    {
      // Resultado da soma na variável inteira
      Integer mul = Integer.parseInt(x1.toString())*x2;
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.IMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }
    else
    {
      // Resultado da soma na variável float
      Float mul = Float.parseFloat(x1.toString())*Float.parseFloat(x2.toString());
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }

    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  
  
  /**
   * Um ID e uma constante float.
   */
  public static void idAndFloatConst()
  {
    Object x1 = Translator.getFromValues(Translator.quad[2]); // Valor da primeira variável
    Float x2 = Float.parseFloat(Translator.quad[4].toString()); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[2]); // LOAD A
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD CONST
    String passo3;
    String passo4;
    
    // Resultado da soma na variável float
    Float mul = Float.parseFloat(x1.toString())*x2;
    Translator.putInValues(Translator.quad[0], mul);
    Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
    passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
    passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável

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
    Integer x1 = Integer.parseInt(Translator.quad[2].toString()); // Valor da primeira variável
    Object x2 = Translator.getFromValues(Translator.quad[4]); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[4]); // LOAD A
    String passo3;
    String passo4;
    
    if (x1 instanceof Integer)
    {
      // Resultado da soma na variável inteira
      Integer mul = x1*Integer.parseInt(x2.toString());
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.IMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }
    else
    {
      // Resultado da soma na variável float
      Float mul = Float.parseFloat(x1.toString())*Float.parseFloat(x2.toString());
      Translator.putInValues(Translator.quad[0], mul);
      Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
      passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
      passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável
    }

    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  
  /**
   * Uma constante float e um ID
   */
  public static void floatConstAndId()
  {
    Float x1 = Float.parseFloat(Translator.quad[1].toString()); // Valor da primeira variável
    Object x2 = Translator.getFromValues(Translator.quad[4]); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[4]); // LOAD A
    String passo3;
    String passo4;
    
    // Resultado da soma na variável float
    Float mul = x1*Float.parseFloat(x2.toString());
    Translator.putInValues(Translator.quad[0], mul);
    Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
    passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
    passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável

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
    Integer x1 = Integer.parseInt(Translator.quad[2].toString()); // Valor da primeira variável
    Integer x2 = Integer.parseInt(Translator.quad[4].toString()); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD CONST
    String passo3;
    String passo4;
    
    // Resultado da soma
    Integer mul = x1*x2;
    Translator.putInValues(Translator.quad[0], mul);
    Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
    passo3 = (Translator.labelCounter++) + ": "+Opcode.IMUL; // Multiplica os dois do topo da pilha
    passo4 = (Translator.labelCounter++) + ": "+Opcode.ISTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável

    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
  
  
  /**
   * Duas constantes floats.
   */
  public static void twoFloatConsts()
  {
    Float x1 = Float.parseFloat(Translator.quad[2].toString()); // Valor da primeira variável
    Float x2 = Float.parseFloat(Translator.quad[4].toString()); // Valor da segunda variável
    Translator.putInCodes(Translator.quad[0]); // Guarda o código da variável
    
    // Agora escreve-se o código de pilha
    String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[2]; // LOAD CONST
    String passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[4]; // LOAD CONST
    String passo3;
    String passo4;
    
    // Resultado da soma
    Float mul = x1*x2;
    Translator.putInValues(Translator.quad[0], mul);
    Translator.putInCodes(Translator.quad[0]); // Armazena a variável com o seu código
    passo3 = (Translator.labelCounter++) + ": "+Opcode.FMUL; // Multiplica os dois do topo da pilha
    passo4 = (Translator.labelCounter++) + ": "+Opcode.FSTORE+" "+Translator.varCode.get(Translator.quad[0]); // Armazena na variável

    String passo5 = (Translator.labelCounter++) + ": "+Opcode.POP;
    
    Translator.program.add(passo1);
    Translator.program.add(passo2);
    Translator.program.add(passo3);
    Translator.program.add(passo4);
    Translator.program.add(passo5);
  }
}
