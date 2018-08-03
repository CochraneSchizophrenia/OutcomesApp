package core;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import trialAndOutcome.TrialObject;
import trialAndOutcome.writeBack;
@XmlRootElement
public class Database {
	
	public Database() {
		super();
	}

	List<TrialObject> trialList = new ArrayList<>();
	protected String reviewName = "";
	
	@XmlElement(name = "TRIAL")
	public List<TrialObject> getTrialList() {
		return trialList;
	}
	public void setTrialList(List<TrialObject> trialList) {
		this.trialList = trialList;
	}
	
	public void makeList() throws ParserConfigurationException, IOException, SAXException{
		
		
		ParseReview parser = new ParseReview();
		Document[] reviewArray = parser.chooseAndParse(); //contains reviews specified by user via pop up browsing window
		
		for (int i = 0; i < reviewArray.length; i++) {
			int numberOfStudies = parser.numberOfIncludedStudies(reviewArray[i]);//looks at how many trials there are to extract
			TrialObject a = new TrialObject(); //makes TrialObject with default empty constructor. If there are trials included in this review, the proper constructer is called in the for-loop.
			for (int j = 0; j < numberOfStudies; j++) {

				a = new TrialObject(reviewArray[i], j);//extracts all data of the specified trial and dumps it into the trial list
				trialList.add(a);
				
				
				writeBack wbObj = new writeBack();
				wbObj.cleanReview(a, parser, i);
				
				//System.out.println("Trial " + a.aauthorYearLetter + " added!");

			}
			reviewName = a.getReviewTitle();
			System.out.println(reviewName);
			System.out.println("After wb obj");
		}
		
	}
	

}
