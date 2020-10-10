package gui;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class SaveOptionPane extends JPanel {
	private JTextField name = new JTextField(15);

	public SaveOptionPane() {
		add(new JLabel("name:"));
		add(name);
		name.setDocument(new JTextFieldLimit(5));
		add(Box.createHorizontalStrut(5)); 
	}

	public String getName() {
		return name.getText();
	}
}

@SuppressWarnings("serial")
class JTextFieldLimit extends PlainDocument {
	  private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }
	 /**
	  * <p>
	  * 텍스트필드가 오프셋만큼 글자가 넘어가지 않게 만든다.
	  * </p>
	  */
	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}
