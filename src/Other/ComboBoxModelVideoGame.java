package Other;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import Pojo.VideoGame;

public class ComboBoxModelVideoGame extends DefaultComboBoxModel<VideoGame> {
	  /**
	 * 
	 */
	private static final long serialVersionUID = -5731397407761738954L;
	public ComboBoxModelVideoGame(VideoGame[] item ) {
	        super(item);
	    }
	  @Override
	    public VideoGame getSelectedItem() {
		  VideoGame selected = (VideoGame) super.getSelectedItem();
	 
	  
	 
	        return selected;
	    }
	  
}
