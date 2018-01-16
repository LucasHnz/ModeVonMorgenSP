package Backend;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextDoc extends PlainDocument{
	private int maxLength;
	
	public TextDoc(int maxLength)	{
		this.maxLength=maxLength;
    }
	
	public void insertString(int offs,String str,AttributeSet a) throws BadLocationException{
		if(str.length()==0)
			return;
		if(getLength()+str.length()<maxLength){
			super.insertString(offs,str,a);
        }
    }
}
