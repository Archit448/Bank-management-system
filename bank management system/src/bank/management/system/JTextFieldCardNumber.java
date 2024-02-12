
package bank.management.system;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class JTextFieldCardNumber extends PlainDocument{
    
    private int limit;
    
    public JTextFieldCardNumber(int limit ){
        
        this.limit=limit;
     
    }
    
 public void insertString(int offset , String str , AttributeSet set )throws BadLocationException{
      
     if (str==null){
         return;
         
     }
     
        if(getLength() + str.length()<= limit){
            
            str = str.toString();
            
            super.insertString(offset , str , set);
        }
     }
}

