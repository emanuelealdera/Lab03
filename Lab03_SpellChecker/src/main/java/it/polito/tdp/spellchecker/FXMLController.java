/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.WordRich;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    private Dictionary dictionary = new Dictionary ();
    
    @FXML
    private Button btnClearText;
    
    @FXML
    private Button btnSpellCheck;
    
    @FXML 
    private TextField txtArea;
    
    @FXML
    private TextArea txtAreaWrongWords;
    
    @FXML
    private Text txtPerformance;
    
    @FXML 
    private Text txtNumberErrors;
    
    @FXML
    private ChoiceBox <String> choiceBox = new ChoiceBox<>();
    
    private String it="Italian";
    private String en="English";
    
    
    
    
    void doClearText (ActionEvent event) {
    	this.txtArea.clear();
    	this.txtAreaWrongWords.clear();
    	this.txtNumberErrors.setText("");
    	this.txtPerformance.setText("");
    }
    
    void doSpellCheck (ActionEvent event) throws IOException {
    	
    	choiceBox.getItems().clear();
    	choiceBox.getItems().add(it);
    	choiceBox.getItems().add(en);
    	String language = choiceBox.getValue();
    	String textComplete = txtArea.getText();
    	textComplete.replaceAll(" <>-.,ç@#ù][^'=)(/&%$£  ", "");
    	String str[]=textComplete.split(" ");
    	List <WordRich> inputTextCheck = new ArrayList <> ();
    	for (String s:str) {
    		inputTextCheck.add(WordRich.toWordRich(s));
    	}
    	dictionary.loadDictionary(language);
    	List wrongWords=dictionary.spellCheckText(inputTextCheck);
    	txtNumberErrors.setText("The text contains "+wrongWords.size()+" errors");
    	

    }
    
    
    
    
    
    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    }
}


