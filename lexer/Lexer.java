package lexer;

import java.io.IOException;
import java.util.Hashtable;

import symbols.Type;

public class Lexer
{
  public static int line = 1;
  
  char peek = ' ';
  
  Hashtable <String, Word> words = new Hashtable <String, Word> ();
  
  /**
   * Método que reserva uma palavra chave.
   * @param w - palavra chave
   */
  public void reserve (Word w)
  {
    words.put(w.lexeme, w);
  }
  
  /**
   * Construtor
   */
  public Lexer ()
  {
    // Reserva palavras-chave selecionadas.
    reserve(new Word("if",    Tag.IF));
    reserve(new Word("else",  Tag.ELSE));
    reserve(new Word("while", Tag.WHILE));
    reserve(new Word("do",    Tag.DO));
    reserve(new Word("break", Tag.BREAK));
    
    // Reserva lexemas para objetos definidos em outras partes.
    reserve(Word.True);
    reserve(Word.False);
    reserve(Type.Int);
    reserve(Type.Char);
    reserve(Type.Bool);
    reserve(Type.Float);
  }
  
  /**
   * Lê o próximo caractere de entrada na variável peek. O nome readCh é
   * reutilizado ou sobrecarregado para para auxiliar a reconhecer tokens
   * compostos.
   * 
   * @throws IOException
   */
  public void readCh () throws IOException
  {// TODO mudar para ler do arquivo
    peek = (char)System.in.read();
  }
  public boolean readCh (char c) throws IOException
  {// TODO mudar para ler do arquivo
    readCh();
    if (peek != c)
    {
      return false;
    }
    peek = ' ';
    return true;
  }
  
  /**
   * A função scan começa ignorando espaços em branco. Ela reconehce
   * tokens compostos como '<=' e números, antes de reconhecer as palavras.
   * 
   * @return
   * @throws IOException
   */
  public Token scan () throws IOException
  {
    for (;; readCh())
    {
      if (peek == ' ' || peek == '\t' )
      {
        continue;
      }
      else if (peek == '\n' || peek == '\r')
      {
        line = line+1;
      }
      else
      {
        break;
      }
    }
    
    switch (peek)
    {
      case '&':
        if (readCh('&'))
        {
          return Word.and;
        }
        else
        {
          return new Token('&');
        }
      case '|':
        if (readCh('|'))
        {
          return Word.or;
        }
        else
        {
          return new Token('|');
        }
      case '=':
        if (readCh('='))
        {
          return Word.eq;
        }
        else
        {
          return new Token('=');
        }
      case '!':
        if (readCh('='))
        {
          return Word.ne;
        }
        else
        {
          return new Token('!');
        }
      case '<':
        if (readCh('='))
        {
          return Word.le;
        }
        else
        {
          return new Token('<');
        }
      case '>':
        if (readCh('='))
        {
          return Word.ge;
        }
        else
        {
          return new Token('>');
        }
    }
    
    if (Character.isDigit(peek))
    {
      int v = 0;
      
      do
      {
        v = 10*v + Character.digit(peek, 10);
        readCh();
      } while (Character.isDigit(peek));
      
      if (peek != '.') // TODO verificar
      {
        return new Num(v);
      }
      
      float x = v;
      float d = 10;
      
      for (;;)
      {
        readCh();
        if (!Character.isDigit(peek))
        {
          break;
        }
        x = x + Character.digit(peek, 10) / d;
        d = d*10;
      }
      return new Real(x);
    }
    
    if (Character.isLetter(peek))
    {
      StringBuffer b = new StringBuffer();
      
      do
      {
        b.append(peek);
        readCh();
      } while (Character.isLetterOrDigit(peek));
      
      String s = b.toString();
      
      Word w = (Word)words.get(s);
      
      if (w != null)
      {
        return w;
      }
      
      w = new Word(s, Tag.ID);
      words.put(s,w);
      
      return w;
    }
    Token tok = new Token(peek);
    peek = ' ';
    return tok;
  }
}
