package translator;

public class FalseBranch
{
  /**
   * Verifica se a linha da quádrupla é uma operação de desvio condicional negado.
   * 
   * @return resposta
   */
  public static boolean isFalseBranch()
  {
    if (Translator.quad[0].equals("iffalse"))
    {
      String passo1;
      String passo2;
      String passo3;
      
      if (Translator.isId(1))
      {
        Translator.putInCodes(Translator.quad[1]); // Guarda o código da variável
        passo1 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[1]); // LOAD value
      }
      else
      {
        passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[1]; // LOAD constant value
      }
      
      if (Translator.isId(3))
      {
        Translator.putInCodes(Translator.quad[3]); // Guarda o código da variável
        passo2 = (Translator.labelCounter++) + ": "+Opcode.ALOAD+" "+Translator.varCode.get(Translator.quad[3]); // LOAD value
      }
      else
      {
        passo2 = (Translator.labelCounter++) + ": "+Opcode.LDC+" "+Translator.quad[3]; // LOAD constant value
      }
      
      passo3 = makeStep(); // Passo de branch
      
      Translator.program.add(passo1);
      Translator.program.add(passo2);
      Translator.program.add(passo3);
      
      return true;
    }
    return false;
  }
  
  public static String makeStep()
  {
    String op = "";
    switch(Translator.quad[2])
    {
    case "<":
      op = Opcode.IF_ICMPGE;
      break;
    case "<=":
      op = Opcode.IF_ICMPGT;
      break;
    case  "==":
      op = Opcode.IF_ICMPNE;
      break;
    case ">":
      op = Opcode.IF_ICMPLE;
    case ">=":
      op = Opcode.IF_ICMPLT;
      break;
    case "!=":
      op = Opcode.IF_ICMPEQ;
      break;
    default:
        break;
    }
     
    return (Translator.labelCounter++) + ": "+op+" "+Translator.getFromValues(Translator.quad[5]);
  }

}
