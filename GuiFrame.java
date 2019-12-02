import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUIFrame extends JFrame implements ActionListener {

	/**
	 * GUI Frame for CompetitorList
	 */

	    // The staff list to be searched.
	    private CompetitorList complist;
	    
	    //GUI components
	    JTextField  [] scoresF;
	    JTextField result;
	    JTextField searchField;
	    JButton search;
	    JScrollPane scrollList;
	    JButton showListById, showListByName, update, close;
	    JTextArea displayList;
	    
	    JButton showLevel, showOverallScore;
	    
//	    //also create grid of buttons
//	    GridOfButtonsFrame gobf; 
	    
	    /**
	     * Create the frame with its panels.
	     * @param list	The staff list to be searched.
	     */
	    public GUIFrame (CompetitorList list)
	    {
	        this.complist = list;
	        
	        //set up window title
	        setTitle("Competitor List");
	        //disable standard close button
			setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	 
			setupSouthPanel();
			setupNorthPanel();
			setupCenterPanel();
			setupEastPanel();

	        //pack and set visible
	        pack();
	        setVisible(true);
	        
//	        gobf = new GridOfButtonsFrame(complist);
//	        gobf.pack(); 
//	        gobf.setVisible(true);
	    }
	    
	    private void setupCenterPanel() {
	        displayList = new JTextArea(15,20);
	        displayList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
	        displayList.setEditable(false);
	        scrollList = new JScrollPane(displayList);
	        this.add(scrollList,BorderLayout.CENTER);
	       
	    }
	        
	   private void setupEastPanel() {
	   JPanel eastPanel = new JPanel();
	   eastPanel.setLayout(new GridLayout(6,2));
	   
	   JLabel scoresL = new JLabel("Scores");
	   eastPanel.add(scoresL);
	   JPanel scoresPanel = new JPanel();
	   scoresF = new JTextField[5];
	   	for (int i = 0; i < 5; i++) {
	   		scoresF[i] = new JTextField(2);
	   		
	   		scoresPanel.add((scoresF[i]));
	   	}
	   	eastPanel.add(scoresPanel);
	   	JLabel dummy = new JLabel("");
	   	eastPanel.add(dummy);
	   	update = new JButton ("Update");
	   	update.addActionListener(this);
	   	update.setEnabled(false);
	   	eastPanel.add(update);
	   
	   this.add(eastPanel, BorderLayout.EAST); 
	   	}
	   
	    
	    private void setupSouthPanel() {
	        //search panel contains label, text field and button
	        JPanel searchPanel = new JPanel();
	        searchPanel.setLayout(new GridLayout(1,3));
	        searchPanel.add(new JLabel("Enter ID"));   
	        searchField = new JTextField(5);
	        searchPanel.add(searchField);   
	        search = new JButton("Search");  
	        searchPanel.add(search);    
	        //specify action when button is pressed
	        search.addActionListener(this) ;
	        
	        //Set up the area where the results will be displayed.
	        result= new JTextField(25);     
	        result.setEditable(false);
	        
	        //set up south panel containing 2 previous areas
	        JPanel southPanel = new JPanel();
	        southPanel.setLayout(new GridLayout(2,1));
	        southPanel.add(searchPanel);
	        southPanel.add(result);
	        
	        //add south panel to the content pane
	        this.add(southPanel, BorderLayout.SOUTH);   	
	    }
	    
	    private void setupNorthPanel() {
	        //add north panel containing some buttons
	        JPanel northPanel = new JPanel();
	        showListById = new JButton("List By ID");
	        showListById.addActionListener(this);
	        
	        showListByName = new JButton("List By Name");
	        showListByName.addActionListener(this);
	        
	        //JButton showLevel, showOverallScore
	        showLevel = new JButton("Show Level");
	        showLevel.addActionListener(this);
        
	        showOverallScore = new JButton("Show Overall Score");
	        showOverallScore.addActionListener(this);
	        
	        close = new JButton("Close");
	        close.addActionListener(this);
	        
	        northPanel.add (showListById);
	        northPanel.add(showListByName);
	        northPanel.add(showLevel);
	        northPanel.add(showOverallScore);
	        northPanel.add(close);
	        this.add(northPanel, BorderLayout.NORTH);
	    }
	    
	    //come here when button is clicked
	    //find which button and act accordingly
	    public void actionPerformed(ActionEvent e) 
	    { 
	    	if (e.getSource() == search) {
	    		//displayList.setText("Show");
	    		search();
	    	}
//	    	else if (e.getSource() == showListById) {
//	    		displayList.setText(staffList.listByID());
//	    	}
//	    	else if (e.getSource() == showListByName ) {
//	    		displayList.setText(staffList.listByName());
//	    	}
	    	else if (e.getSource() == showLevel) {
	    		displayList.setText(complist.showLevel());
	    	}
	    	else if (e.getSource() == showOverallScore) {
	    		displayList.setText(complist.showOverallScore());
	    	}
	    	else if (e.getSource() == close) {
	    		JOptionPane.showMessageDialog(this, 
	    				 "Do 'end of program' things instead of showing this");
	    		System.exit(0);
	    	}
	    }  
	  
	    private void search() {
	    	//get search text and search comp list
	    	//setting result text 
	        String searchString = searchField.getText().trim();
	        if(searchString.length() > 0) {
	        	Competitor person = complist.findByCompNumber(Integer.parseInt(searchString));
	            if (person != null ) {
	            	result.setText(person.getShortDetails());  
	            	//gobf.disableButton(person.getFullDetails());
	            }
	            else
	            	result.setText("not found");
	        }   
	        else
	        	result.setText("no text entered");
	    }

}
