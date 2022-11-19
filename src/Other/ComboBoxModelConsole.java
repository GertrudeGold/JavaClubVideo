package Other;



import javax.swing.DefaultComboBoxModel;

import Pojo.Console;


public class ComboBoxModelConsole extends DefaultComboBoxModel<Console> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4356200121323171278L;
	public ComboBoxModelConsole(Console[] item ) {
	        super(item);
	    }
	  @Override
	    public Console getSelectedItem() {
		  Console selected = (Console) super.getSelectedItem();
	 
	  
	 
	        return selected;
	    }
	  
}
