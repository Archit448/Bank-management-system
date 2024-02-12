
package bank.management.system;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class JTextFieldPin extends PlainDocument {
    
    private int limit ;
    
     public JTextFieldPin(int limited){
       
        this.limit=limited;
                
     }
    public void insertString(int offset, String str, AttributeSet set)throws BadLocationException{
     
          if (str == null){
             return;
         }
         
        if(getLength() + str.length()<= limit){
            
            str = str.toString();
            
            super.insertString(offset , str , set);
        }
        
    }    
}
