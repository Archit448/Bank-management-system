/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ARCHIT
 */
public class JTextFieldPan extends PlainDocument {
        
    private int limit ;
    
     public JTextFieldPan(int limited){
       
        this.limit=limited;
                
     }
    public void insertString(int offset, String str, AttributeSet set)throws BadLocationException{
     
          if (str == null){
             return;
         }
         
        if(getLength() + str.length()<= limit){
            
            str = str.toUpperCase();
            
            super.insertString(offset , str , set);
        }
        
    }
}

