import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class manager {
	
	private CompetitorList complist;
	
	public manager(){
		  complist = new CompetitorList();
	}
	
	public void run(){
		complist.readFile("T_Competitor.csv");
		complist.readFile("A_Competitor.csv");
		complist.readFile("C_competitor.csv");
	
		//show GuiFrame
		
		//create mainGUI with CompetitorList object
		GuiFrame gui = new GuiFrame(complist);
		gui.setVisible(true);
		
	System.out.println(complist.getTableOfCompetitors());
	System.out.println(complist.getCompetitorReport());
	}
}



