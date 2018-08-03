package core;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseReview {
	public String[] paths;
	public File[] files;
	public Document[] rm5;
	
	public Document[] chooseAndParse() throws ParserConfigurationException{
		
JFileChooser chooser = new JFileChooser();
chooser.setMultiSelectionEnabled(true);
		
files = null;
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnValue = chooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			 files = chooser.getSelectedFiles();
		}
		//File review = chooser.getSelectedFile().getAbsoluteFile();
		paths = new String[files.length];

		rm5 = new Document[files.length];
			for (int i = 0; i < files.length; i++) {
				
				DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
				builderFactory.setIgnoringComments(true);
				builderFactory.setIgnoringElementContentWhitespace(true);
				
				try {
					paths[i] = files[i].getAbsolutePath();//stores all the paths for the parsed files
					DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
					rm5[i] = dBuilder.parse(files[i]);
					rm5[i].normalize();
					System.out.println("parsed");
				} catch (ParserConfigurationException e) {
				} catch (SAXException e) {
				} catch (IOException e) {
				} 
			}
			return rm5;
	}
	
	
	
	
	
	protected int numberOfIncludedStudies(Document rm5){
		
		
		// Gets root element of parsed XML document, moves to included studies section and returns length of included studies list.
		NodeList rootList = rm5.getElementsByTagName("COCHRANE_REVIEW");
		Node rootNode = rootList.item(0);
		Element rootElement = (Element) rootNode;
		
		NodeList characteristicsOfStudiesList = rootElement.getElementsByTagName("CHARACTERISTICS_OF_STUDIES");
		Node characteristicsOfStudiesNode = characteristicsOfStudiesList.item(0);
		Element characteristicsOfStudiesElement = (Element) characteristicsOfStudiesNode;
		
		NodeList characteristicsOfIncludedStudiesList = 
				characteristicsOfStudiesElement.getElementsByTagName("CHARACTERISTICS_OF_INCLUDED_STUDIES");
		Node characteristicsOfIncludedStudiesNode = characteristicsOfIncludedStudiesList.item(0);
		Element characteristicsOfIncludedStudiesElement = (Element) characteristicsOfIncludedStudiesNode;
		
		NodeList includedStudiesList = characteristicsOfIncludedStudiesElement.getElementsByTagName("INCLUDED_CHAR");
		
		return includedStudiesList.getLength();
	}
	
	

}
