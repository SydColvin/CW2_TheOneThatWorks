import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

/**
	 * GUI Frame for CompetitorList
	 */
public class GuiFrame extends JFrame implements ActionListener {
	
	/**
	 *  The staff list to be searched.
	 */
	    The staff list to be searched.
	    private CompetitorList complist;
	    
	/**
	 * GUI  components
	 */
	    JTextField  [] scoresF;
	    JTextField result, result2, result3;
	    
	    JTextField  searchField, searchField1, searchField2, searchField3, searchField4;
	    JButton search, search2, search4;
	    
	    JScrollPane scrollList;
	    
	    JButton ListByIdAsc, ListByIdDes, showListByName,close;
	    JTextArea displayList;
	    
	    JButton update, game, score;
	    
	    JButton showLevel, OverallScoreAsc, OverallScoreDes;
	     
	    JButton vcaCompList, shcCompList, stCompList, showAllList;
	    
	    /**
	     * Create the frame with its panels.
	     * @param list	The staff list to be searched.
	     */
	    public GuiFrame (CompetitorList list)
	    {
	        this.complist = list;
	        
	    /**
	    *  set up window title
	    */    
	        setTitle("Competitor List");
	        //disable standard close button
			setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	 
			setupSouthPanel();
			setupNorthPanel();
			setupWestPanel();
			setupEastPanel();

            /**
	    *  pack and set visible
	    */    
	        pack();
	        setVisible(true);
	        
	    }
	    
	     /**
	     * Create the west panel.
	     * @param 	The west panel to be displayed.
	     */
	    private void setupWestPanel() {
	        displayList = new JTextArea(15,100);
	        displayList.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
	        displayList.setEditable(false);
	        scrollList = new JScrollPane(displayList);
	        this.add(scrollList,BorderLayout.CENTER);
	    }
	    /**
	     * Set up the east panel. All labels, search buttons and result windows are added.
	     * Set up the update button in order to update the scores
	     * @param 	search2 the search button2 
	     * @param 	result3 the result from search2
	     * @param 	result2 the result 
	     * @param 	update the result from result2
	     */
	    private void setupEastPanel() {
	 	   JPanel eastPanel = new JPanel();
	 	   eastPanel.setLayout(new GridLayout(6,2)); 
		    
	 	   eastPanel.add(new JLabel("Update scores"));
	 	   eastPanel.add(new JLabel(""));
	 	   eastPanel.add(new JLabel(""));
	 	   eastPanel.add(new JLabel(""));
		    
	 	   eastPanel.add(new JLabel("Enter CN"));
	 	   searchField1 = new JTextField(5);
	 	   eastPanel.add(searchField1); 
	 	   search2 = new JButton("Search");  
	           eastPanel.add(search2); 
	           search2.addActionListener(this) ;
	 	   result3 = new JTextField(10); 
	 	   eastPanel.add(result3);
		   result3.setEditable(false);
		    
	 	   eastPanel.add(new JLabel("game (1 to 5)"));
	 	   searchField2 = new JTextField(5);
	 	   eastPanel.add(searchField2); 
	 	   eastPanel.add(new JLabel(""));
	 	   eastPanel.add(new JLabel(""));
		    
	 	   eastPanel.add(new JLabel("score"));
	 	   searchField3 = new JTextField(5);
	 	   eastPanel.add(searchField3); 
	 	   result2 = new JTextField(10);     
	           result2.setEditable(false);
		    
	 	   update = new JButton("Update");  
	           eastPanel.add(update); 
	           update.addActionListener(this);
	           eastPanel.add(result2);
	 	   
	      //search panel contains label
	        eastPanel.add(new JLabel ("Competitors by Level"));
	        eastPanel.add(new JLabel(""));
		 	eastPanel.add(new JLabel(""));
		 	eastPanel.add(new JLabel(""));
		 //search panel contains label, text field and button   
	        eastPanel.add(new JLabel("Enter Level"));
		 	searchField4 = new JTextField(5);
		 	eastPanel.add(searchField4); 
		 	search4 = new JButton("Search");  
		    eastPanel.add(search4);
		  //specify action when button is pressed
		    search4.addActionListener(this) ;
	        
		  //add east panel to the content pane
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
	        JPanel northPanel = new JPanel(new GridLayout(2,5));
	        
	      //JButton lists competitors by id in ascending order 
	        ListByIdAsc = new JButton("List By ID Asc.");
	        ListByIdAsc.addActionListener(this);
	        
	      //JButton lists competitors by id in descending order
	        ListByIdDes = new JButton("List By ID Des.");
	        ListByIdDes.addActionListener(this);
	        
	      //JButton lists competitors by name
	        showListByName = new JButton("List By Name");
	        showListByName.addActionListener(this);
	        
	       //JButton showLevel
	        showLevel = new JButton("Show Level");
	        showLevel.addActionListener(this);
	        
	      //JButton shows id by overall scores in ascending order
	        OverallScoreAsc = new JButton("Overall Score Asc.");
	        OverallScoreAsc.addActionListener(this);
	        
	      //JButton shows id by overall scores in descending order
	        OverallScoreDes = new JButton("Overall Score Des.");
	        OverallScoreDes.addActionListener(this);
	        
	        //vcaCompList, shcCompList, stCompList, all competitors list;
	        vcaCompList = new JButton("Show VCACompetitor");
	        vcaCompList.addActionListener(this);
	       
	        shcCompList = new JButton("Show SHCCompetitor");
	        shcCompList.addActionListener(this);
	      

	        stCompList = new JButton("Show STCompetitor");
	        stCompList.addActionListener(this);
	       
	        showAllList = new JButton("Show All");
	        showAllList.addActionListener(this);
	       
	        //Close Button
	        close = new JButton("Close");
	        close.addActionListener(this);
	        
	        //Add buttons to North Pane
	        northPanel.add(ListByIdAsc);
	        northPanel.add(ListByIdDes);
	        northPanel.add(showListByName);
	        northPanel.add(showLevel);
	        northPanel.add(OverallScoreAsc);
	        northPanel.add(OverallScoreDes);
	        northPanel.add(vcaCompList);
	        northPanel.add(shcCompList);
	        northPanel.add(stCompList);
	        northPanel.add(showAllList);
	        northPanel.add(close);
	        
	      //add north panel to the content pane
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
		    else if (e.getSource() == ListByIdAsc) {
	    	displayList.setText(complist.CNList()); 
	    	}
		    else if (e.getSource() == ListByIdDes) {
		    	displayList.setText(complist.CNListR()); 
		    	}
	    	else if (e.getSource() == showListByName ) {
    		displayList.setText(complist.listByName());
	    	}
	    	else if (e.getSource() == showLevel) {
	    		displayList.setText(complist.showLevel());
	    	}
	    	else if (e.getSource() == OverallScoreAsc) {
	    		displayList.setText(complist.listByOverallScore());
	    	}
	    	else if (e.getSource() == OverallScoreDes) {
	    		displayList.setText(complist.listByOverallScoreR());
	    	}
	    	else if (e.getSource() == vcaCompList){
	    		displayList.setText(complist.showvcalist());
	    	}
	    	else if (e.getSource() == shcCompList){
	    		displayList.setText(complist.showshclist());
	    	}
	    	else if (e.getSource() == stCompList){
	    		displayList.setText(complist.showstlist());
	    	}
	    	else if (e.getSource() == showAllList){
	    		displayList.setText(complist.showstlist() + "\n \n" + complist.showshclist()+ "\n \n" + complist.showvcalist());
	    	}
	    	else if(e.getSource() == search2) {
	    		//displayList.setText("Show");
	    		search2();
	    	}
	    	else if(e.getSource() == update) {
	    		//displayList.setText("Show");
	    		update();
	    	}
	    	else if (e.getSource() == close) {
	    	//	JOptionPane.showMessageDialog(this, 
	    	//			 "Do 'end of program' things instead of showing this");
	    		System.exit(0);
	    	}
	    	else if (e.getSource() == search4) {
	    		String input = searchField4.getText().trim();
	    		displayList.setText(complist.showSetLevel(input));
	    	}
	    }  
	  
	    private void search() {
	    	//get search text and search comp list
	    	//setting result text 
	    	try {
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
	    
		catch (NumberFormatException nfe) {
			String error = "Number conversion error " + nfe.getMessage();
			System.out.println(error);
			}
		}
	    	
 		private void update() {
	 		  try {
	 		   String searchString1 = searchField1.getText().trim();
	 		   Competitor c = complist.findByCompNumber(Integer.parseInt(searchString1));
	 		   if (c != null){
		 		   String inputStringGame = searchField2.getText().trim();
		 		   int game = Integer.parseInt(inputStringGame)-1;
		 		   String inputStringScore = searchField3.getText().trim();
		 		   int score = Integer.parseInt(inputStringScore);
		 		   c.setScore(game, score);
		 		   result2.setText(Double.toString(Math.round(c.getOverallScore() * 100.0) / 100.0));
	 		   }
	 		   else {result2.setText("CN not valid.");}
	 		   }
	 	   
			catch (NumberFormatException nfe) {
				String error = "Number conversion error (update() function)" + nfe.getMessage();
				System.out.println(error);
				}
	 	   }
	 	   	   
	 	   
	 	   private void search2() {
	 		  try {
	 		   String searchString1 = searchField1.getText().trim();
		        if(searchString1.length() > 0) {
		        	Competitor person = complist.findByCompNumber(Integer.parseInt(searchString1));
		            if (person != null ) {
		            	result3.setText(Arrays.toString(person.getScoreArray()));  
		            	//gobf.disableButton(person.getFullDetails());
		            }
		            else
		            	result3.setText("not found");
		        }   
		        else
		        	result3.setText("no text entered");
	 		  }
				catch (NumberFormatException nfe) {
					String error = "Number conversion error (search 2 function) " + nfe.getMessage();
					System.out.println(error);
					}
	 		     
	 	   }
	 
	 	  
}


