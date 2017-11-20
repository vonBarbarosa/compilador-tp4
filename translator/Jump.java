package translator;

public class Jump
{
  /**
   * Verifica se a linha da quádrupla é uma operação de desvio incondicional.
   * 
   * @return resposta
   */
  public static boolean isJump()
  {
    if (Translator.quad[0].equals("goto"))
    {
      String passo1 = (Translator.labelCounter++) + ": "+Opcode.LDC+" 0"; // LOAD 0
      String passo2 = (Translator.labelCounter++) + ": "+Opcode.IFEQ+" "+Translator.getFromValues(Translator.quad[1]); // Jump se zero
      
      Translator.program.add(passo1);
      Translator.program.add(passo2);
      
      return true;
    }
    return false;
  }
}
