package trialAndOutcome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import core.ParseReview;
import references.ReferenceObject;

public class writeBack {
	public writeBack() {
		
	}
	
	public void cleanReview(TrialObject a, ParseReview parser, int i) throws ParserConfigurationException, IOException, SAXException {
	     
			
			 ////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    try {
				

				// Get the staff element , it may not working if tag has spaces, or
				// whatever weird characters in front...it's better to use
				// getElementsByTagName() to get it directly.
				// Node staff = company.getFirstChild();

				// Get the staff element by tag name directly
		    	
				
				Document rm5 = parser.rm5[i];
				
					
					
					Element root = rm5.getDocumentElement();
				    Element rootElement = rm5.getDocumentElement();
				    String namesToCompare = "";
				    //a.charObject.charOutcomesElement.setTextContent("");
				    Element p = rm5.createElement("P");
				    Element br = rm5.createElement("BR");
				    
				    p.appendChild(br);
				    p.appendChild(rm5.createTextNode("--- Outcomes used ---"));
				    a.charObject.charOutcomesElement.appendChild(p);
				    
				    for (OutcomeObject outcome : a.outcomeList) {
				    	Element p2 = rm5.createElement("P");
				    	namesToCompare = outcome.toString();
				    	
				    	
				    	p2.appendChild(rm5.createTextNode(namesToCompare));
				    	a.charObject.charOutcomesElement.appendChild(p2);
				    	
				    }
				    //String newCharOutcomesContent = a.charObject.outcomesString + ". " + namesToCompare;
				    
				   
				    
					
					
				    
				    
				    

				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(rm5);
				
			
				
				String path = "C:\\NewReviews\\" + a.charObject.reviewTitle + ".rm5";
				
				StreamResult result = new StreamResult(new File(path));
				transformer.transform(source, result);

				System.out.println("Done writing");
				
				 try// all code below was originally written for RevManHAL
		            {
		                System.out.println("FilePath: "+path);
		           deleteSpecialChars(path);
		            }
		            catch(Exception e)
		            {
		                System.out.println("FEHLER!");
		                e.printStackTrace();
		            }

			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
				System.out.println("");
			   }
			}
	
	public void deleteSpecialChars(String file) throws IOException
	  {   
	      
	      Reader fr = new InputStreamReader(new FileInputStream(file), "UTF-8");
	      BufferedReader br = new BufferedReader(fr);
	       
	      Writer fw = new OutputStreamWriter(new FileOutputStream(file+"newFile.rm5"), "ISO-8859-1");
	      String line="";
	      
	      
	      while((line=br.readLine())!= null)
	      {
	          
	       //  System.out.println("das ist line: "+line);
	          if(line.contains("Ã¼"))
	          {
	              line = line.replace("Ã¼", "ü");
	              System.out.println("dinna if ue: "+line);  
	          }
	          if(line.contains("¤"))
	           {
	               line = line.replace("¤", "ä");
	               System.out.println("dinna if ae: "+line);  
	           }
	          if(line.contains("¶"))
	           {
	               line = line.replace("¶", "ö");
	               System.out.println("dinna if: oe "+line);  
	           }
	          if(line.contains("Ã&#156;"))
	          {
	              line = line.replace("Ã&#156;", "Ü");
	              System.out.println("dinna if Ue: "+line);  
	          }          
	           if(line.contains("Ã&#159;"))
	           {
	               line = line.replace("Ã&#159;", "ß");
	                 
	           }
	         if(line.contains("Ã&#132;"))
	           {
	               line = line.replace("Ã&#132;", "Ä");
	                 
	           }
	         if(line.contains("Ã&#150;"))
	           {
	               line = line.replace("Ã&#150;", "Ö");
	                
	           }
	           if(line.contains("Â¢"))
	           {
	               line = line.replace("Â¢", "¢");
	                 
	           }        
	                                 
	            if(line.contains("Â£"))
	           {
	               line = line.replace("Â£;", "£");
	                 
	           }          
	          if(line.contains("Â¥"))
	           {
	               line = line.replace("Â¥", "¥");
	                 
	           }
	          if(line.contains("Ã&#8800;"))
	           {
	               line = line.replace("Ã&#8800;", "≠");
	                 
	           }
	          if(line.contains("Â±"))
	           {
	               line = line.replace("Â±", "±");
	                 
	           }
	          if(line.contains("Ã&#8706;"))
	           {
	               line = line.replace("Ã&#8706;", "∂");
	                 
	           }
	           if(line.contains("Ã&#8710;"))
	           {
	               line = line.replace("Ã&#8710;", "∆");
	                 
	           }
	           if(line.contains("Ã&#8719;"))
	           {
	               line = line.replace("Ã&#8719;", "∏");
	                 
	           }          
	           if(line.contains("Ã&#8721;"))
	           {
	               line = line.replace("Ã&#8721;", "∑");
	                 
	           }
	          if(line.contains("Ã&#8730;"))
	           {
	               line = line.replace("Ã&#8730;", "√");
	                 
	           }
	          if(line.contains("Ã&#8776;"))
	           {
	               line = line.replace("Ã&#8776;", "≈");
	                 
	           }
	           if(line.contains("Ã&#8804;"))
	           {
	               line = line.replace("Ã&#8804;", "≤");
	                 
	           }
	           if(line.contains("Ã&#8805;"))
	           {
	               line = line.replace("Ã&#8805;", "≥");
	                 
	           }
	          if(line.contains("Ã&#8593;"))
	           {
	               line = line.replace("Ã&#8593;", "↑");
	                 
	           }
	           if(line.contains("Ã&#8594;"))
	           {
	               line = line.replace("Ã&#8594;", "→");
	                 
	           }
	           if(line.contains("Ã&#8595;"))
	           {
	               line = line.replace("Ã&#8595;", "↓");
	                 
	           }
	           if(line.contains("Ã&#8592;"))
	           {
	               line = line.replace("Ã&#8592;", "←");
	                 
	           }
	           if(line.contains("Ã&#8596;"))
	           {
	               line = line.replace("Ã&#8596;", "↔");
	                 
	           }
	           if(line.contains("Ã&#129;"))
	           {
	               line = line.replace("Ã&#129;", "Á");
	                 
	           }
	          if(line.contains("Ã&#128;"))
	           {
	               line = line.replace("Ã&#128;", "À");
	                 
	           }
	          if(line.contains("Ã&#130;"))
	           {
	               line = line.replace("Ã&#130;", "Â");
	                 
	           }
	          if(line.contains("Ã&#258;"))
	           {
	               line = line.replace("Ã&#258;;", "Ă");
	                 
	           }
	          if(line.contains("Ã&#256;"))
	           {
	               line = line.replace("Ã&#256;", "Ā");
	                 
	           }
	           if(line.contains("Ã&#131;"))
	           {
	               line = line.replace("Ã&#131;", "Ã");
	                 
	           }
	           if(line.contains("Ã&#133;"))
	           {
	               line = line.replace("Ã&#133;", "Å");
	                 
	           }
	           if(line.contains("Ã&#260;"))
	           {
	               line = line.replace("Ã&#260;", "Ą");
	                 
	           }
	           if(line.contains("Ã&#134;"))
	           {
	               line = line.replace("Ã&#134;", "Æ");
	                 
	           }
	           if(line.contains("Ã&#262;"))
	           {
	               line = line.replace("Ã&#262;", "Ć");
	                 
	           }
	           if(line.contains("Ã&#266;"))
	           {
	               line = line.replace("Ã&#266;", "Ċ");
	                 
	           }
	          if(line.contains("Ã&#264;"))
	           {
	               line = line.replace("Ã&#264;", "Ĉ");
	                 
	           }
	           if(line.contains("Ã&#268;"))
	           {
	               line = line.replace("Ã&#268;", "Č");
	                 
	           }
	          if(line.contains("Ã&#135;"))
	           {
	               line = line.replace("Ã&#135;", "Ç");
	                 
	           }
	          if(line.contains("Ã&#270;"))
	           {
	               line = line.replace("Ã&#270;", "Ď");
	                 
	           }
	          if(line.contains("Ã&#144;"))
	           {
	               line = line.replace("Ã&#144;", "Ð");
	                 
	           }
	           if(line.contains("Ã&#137;"))
	           {
	               line = line.replace("Ã&#137;", "É");
	                 
	           }
	          if(line.contains("Ã&#136;"))
	           {
	               line = line.replace("Ã&#136;", "È");
	                 
	           }
	          if(line.contains("Ã&#278;"))
	           {
	               line = line.replace("Ã&#278;", "Ė");
	                 
	           }
	          if(line.contains("Ã&#138;"))
	           {
	               line = line.replace("Ã&#138;", "Ê");
	                 
	           }
	           if(line.contains("Ã&#139;"))
	           {
	               line = line.replace("Ã&#139;", "Ë");
	                 
	           }
	          if(line.contains("Ã&#282;"))
	           {
	               line = line.replace("Ã&#282;", "Ě");
	                 
	           }
	          if(line.contains("Ã&#276;"))
	           {
	               line = line.replace("Ã&#276;", "Ĕ");
	                 
	           }
	          if(line.contains("Ã&#274;"))
	           {
	               line = line.replace("Ã&#274;", "Ē");
	                 
	           }
	          if(line.contains("Ã&#280;"))
	           {
	               line = line.replace("Ã&#280;", "Ę");
	                 
	           }
	          if(line.contains("Ã&#288;"))
	           {
	               line = line.replace("Ã&#288;", "Ġ");
	                 
	           }
	          if(line.contains("Ã&#284;"))
	           {
	               line = line.replace("Ã&#284;", "Ĝ");
	                 
	           }
	          if(line.contains("Ã&#290;"))
	           {
	               line = line.replace("Ã&#290;", "Ģ");
	                 
	           }
	          if(line.contains("Ã&#292;"))
	           {
	               line = line.replace("Ã&#292;", "Ĥ");
	                 
	           }
	          if(line.contains("Ã&#141;"))
	           {
	               line = line.replace("Ã&#141;", "Í");
	                 
	           }
	          if(line.contains("Ã&#140;"))
	           {
	               line = line.replace("Ã&#140;", "Ì");
	                 
	           }if(line.contains("Ã&#142;"))
	           {
	               line = line.replace("Ã&#142;", "Î");
	                 
	           }if(line.contains("Ã&#143;"))
	           {
	               line = line.replace("Ã&#143;;", "Ï");
	                 
	           }
	           if(line.contains("Ã&#300;"))
	           {
	               line = line.replace("Ã&#300;", "Ĭ");
	                 
	           }
	           if(line.contains("Ã&#298;"))
	           {
	               line = line.replace("Ã&#298;", "Ī");
	                 
	           }
	           if(line.contains("Ã&#296;"))
	           {
	               line = line.replace("Ã&#296;", "Ĩ");
	                 
	           }
	           if(line.contains("Ã&#302;"))
	           {
	               line = line.replace("Ã&#302;", "Į");
	                 
	           }
	           if(line.contains("Ã&#145;"))
	           {
	               line = line.replace("Ã&#145;", "Ñ");
	                 
	           }
	           if(line.contains("Ã&#147;"))
	           {
	               line = line.replace("Ã&#147;", "Ó");
	                 
	           }
	           if(line.contains("Ã&#146;"))
	           {
	               line = line.replace("Ã&#146;", "Ò");
	                 
	           }
	           if(line.contains("Ã&#148;"))
	           {
	               line = line.replace("Ã&#148;", "Ô");
	                 
	           }
	           if(line.contains("Ã&#149;"))
	           {
	               line = line.replace("Ã&#149;", "Õ");
	                 
	           }
	           if(line.contains("Ã&#152;"))
	           {
	               line = line.replace("Ã&#152;", "Ø");
	                 
	           }
	           if(line.contains("Ã&#158;"))
	           {
	               line = line.replace("Ã&#158;", "Þ");
	                 
	           }
	           if(line.contains("Ã&#154;"))
	           {
	               line = line.replace("Ã&#154;", "Ú");
	                 
	           }
	           if(line.contains("Ã&#153;"))
	           {
	               line = line.replace("Ã&#153;", "Ù");
	                 
	           }
	           if(line.contains("Ã&#155;"))
	           {
	               line = line.replace("Ã&#155;", "Û");
	                 
	           }
	           if(line.contains("Ã&#157;"))
	           {
	               line = line.replace("Ã&#157;", "Ý");
	                 
	           }
	           if(line.contains("Ã&#376;"))
	           {
	               line = line.replace("Ã&#376;", "Ÿ");
	                 
	           }
	           if(line.contains("Ã&#916;"))
	           {
	               line = line.replace("Ã&#916;", "Δ");
	                 
	           }
	           if(line.contains("Ã&#928;"))
	           {
	               line = line.replace("Ã&#928;", "Π");
	                 
	           }
	        
	      line = line.replace("Â", "");
	      line = line.replace("ƒ", "");
	      line = line.replace("Ã", "");
	      line = line.replace("¼", "");
	      line = line.replace("Â,", "");
	      line = line.replace("ƒ,", "");
	      line = line.replace("Ã,", "");
	      line = line.replace("¼,", "");
	      line = line.replace(",Â", "");
	      line = line.replace(",ƒ", "");
	      line = line.replace(",Ã", "");
	      line = line.replace(",¼", "");      
	      line = line.replace("Ã‚Â", "");
	      line = line.replace("‚±","±");         
	      
	      fw.append(line);
	      
	      }
	      fw.close();
	      br.close();
	      fr.close();
	      
	      
	     File file2 = new File(file);        
	     boolean success = file2.delete();        
	     System.out.println(success);        
	     file2 = new File(file+"newFile.rm5");        
	     file2.renameTo(new File(file));          
	        
	   
	  }
		
	}
	

