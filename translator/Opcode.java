package translator;

public class Opcode
{
  /**
   * Load object in local variable, that you indicate by number, onto the stack
   */
  public static String ALOAD = "aload";
  
  /**
   * Store value in array[index]
   */
  public static String AASTORE = "aastore";
  
  /**
   * load value from array[index]
   */
  public static String AALOAD = "aaload";
  
  /**
   * Push a byte onto the stack as an integer value.
   */
  public static String BIPUSH = "bipush";
  
  /**
   * Load a byte or Boolean value from an array
   */
  public static String BALOAD = "baload";
  
  /**
   * Store a byte or Boolean value in an array
   */
  public static String BASTORE = "bastore";
  
  /**
   * Load a float from an array
   */
  public static String FALOAD = "faload";
  
  /**
   * Store a store in an array
   */
  public static String FASTORE = "fastore";
  
  /**
   * Add two floats.
   */
  public static String FADD = "fadd";
  
  /**
   * Divide two floats.
   */
  public static String FDIV = "fdiv";
  
  /**
   * push 0.0f on the stack
   */
  public static String FCONST_0 = "fconst_0";
  
  /**
   * push 1.0f on the stack
   */
  public static String FCONST_1 = "fconst_1";
  
  /**
   * push 2.0f on the stack
   */
  public static String FCONST_2 = "fconst_2";
  
  /**
   * multiply two floats
   */
  public static String FMUL = "fmul";
  
  /**
   * negate a float
   */
  public static String FNEG = "fneg";
  
  /**
   * return a float
   */
  public static String FRETURN = "freturn";
  
  /**
   * get the remainder from a division between two floats
   */
  public static String FREM = "frem";
  
  /**
   * store a float value into a local variable #index
   */
  public static String FSTORE = "fstore";
  
  /**
   * Subtract two floats
   */
  public static String FSUB = "fsub";
  
  /**
   * compare two floats. If same, pushes 0; else if value 2 greater, pushes 1; 
   * else pushes -1. Returns 1 on NaN.
   */
  public static String FCMPG = "fcmpg";
  
  /**
   * compare two floats. If same, pushes 0; else if value 2 greater, pushes 1; 
   * else pushes -1. Returns -1 on NaN.
   */
  public static String FCMPL = "fcmpl";
  
  /**
   * Store int in array
   */
  public static String IASTORE = "iastore";
  
  /**
   * Loas int from array
   */
  public static String IALOAD = "iaload";
  
  /**
   * load the int value â1 onto the stack
   */
  public static String ICONST_M1 = "iconst_m1";
  
  /**
   * load the int value 0 onto the stack
   */
  public static String ICONST_0 = "iconst_0";
  
  /**
   * load the int value 1 onto the stack
   */
  public static String ICONST_1 = "iconst_1";
  
  /**
   * load the int value 2 onto the stack
   */
  public static String ICONST_2 = "iconst_2";
  
  /**
   * load the int value 3 onto the stack
   */
  public static String ICONST_3 = "iconst_3";
  
  /**
   * load the int value 4 onto the stack
   */
  public static String ICONST_4 = "iconst_4";
  
  /**
   * load the int value 5 onto the stack
   */
  public static String ICONST_5 = "iconst_5";
  
  /**
   * add two ints
   */
  public static String IADD = "iadd";
  
  /**
   * perform a bitwise and on two integers
   */
  public static String IAND = "iand";
  
  /**
   * divide two integers
   */
  public static String IDIV = "idiv";
  
  /**
   * if ints are equal, branch to instruction at branchoffset
   */
  public static String IF_ICMPEQ = "if_icmpeq";
  
  /**
   * if value1 is greater than or equal to value2, branch to instruction at branchoffset
   */
  public static String IF_ICMPGE = "if_icmpge";
  
  /**
   * if value1 is greater than value2, branch to instruction at branchoffset
   */
  public static String IF_ICMPGT = "if_icmpgt";
  
  /**
   * if value1 is less than or equal to value2, branch to instruction at branchoffset
   */
  public static String IF_ICMPLE = "if_icmple";
  
  /**
   * if value1 is less than value2, branch to instruction at branchoffset
   */
  public static String IF_ICMPLT = "if_icmplt";
  
  /**
   * if ints are not equal, branch to instruction at branchoffset
   */
  public static String IF_ICMPNE = "if_icmpne";
  
  /**
   * if value is 0, branch to instruction at branchoffset
   */
  public static String IFEQ = "ifeq";
  
  /**
   * if value is greater than or equal to 0, branch to instruction at branchoffset
   */
  public static String IFGE = "ifge";
  
  /**
   * if value is greater than 0, branch to instruction at branchoffset
   */
  public static String IFGT = "ifgt";
  
  /**
   * if value is less than or equal to 0, branch to instruction at branchoffset
   */
  public static String IFLE = "ifle";
  
  /**
   * if value is less than 0, branch to instruction at branchoffset
   */
  public static String IFLT = "iflt";
  
  /**
   * if value is not 0, branch to instruction at branchoffset
   */
  public static String IFNE = "ifne";
  
  /**
   * load a float value from a local variable #index
   */
  public static String FLOAD = "fload";
  
  /**
   * load an int value from a local variable #index
   */
  public static String ILOAD = "iload";
  
  /**
   * multiply two integers
   */
  public static String IMUL = "imul";
  
  /**
   * negate int
   */
  public static String INEG = "ineg";
  
  /**
   * bitwise int or
   */
  public static String IOR = "ior";
  
  /**
   * store int value into variable #index
   */
  public static String ISTORE = "istore";
  
  /**
   * int subtract
   */
  public static String ISUB = "isub";
  
  /**
   * discard the top value on the stack
   */
  public static String POP = "pop";
  
  /**
   * load constant
   */
  public static String LDC = "ldc";
  
  
}
