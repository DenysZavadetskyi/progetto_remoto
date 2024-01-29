package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class tempopiscina extends Application{
	TextField tnumero = new TextField();
	TextField tquanti = new TextField();
	Label lelenco = new Label();
	Label lmedia = new Label();
	Label lcont = new Label();
	int tempi[];
    int numTempi;
    int pos;
    int contatore;
	
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label ltext = new Label("Numero");
		Label ltext1 = new Label("Quanti");
		Button palloca = new Button();
		palloca.setText("Alloca");
		palloca.setOnAction(e -> alloca());
		
		Button pstampa = new Button();
		pstampa.setText("Stampa");
		pstampa.setOnAction(e -> stampa());
		
		Button pinserisci = new Button();
		pinserisci.setText("Inserisci");
		pinserisci.setOnAction(e -> inserisci());
		
		griglia.add(ltext, 0, 0);
		griglia.add(ltext1, 3, 0);
		griglia.add(tnumero, 1, 0);
		griglia.add(tquanti, 2, 0);
		griglia.add(palloca, 0, 1);
		griglia.add(pinserisci, 0, 2);
		griglia.add(pstampa, 0, 3);
		griglia.add(lelenco, 0, 4,3,4);
		griglia.add(lmedia, 0, 7);
		griglia.add(lcont, 1, 1);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		tnumero.setMaxWidth(50);
		tquanti.setMaxWidth(50);
		
		
		Scene scena = new Scene(griglia);
		finestra.setScene(scena);
		finestra.setTitle("Tempo piscina");
		finestra.show();
	}

	private void alloca() {
		contatore = Integer.parseInt(tquanti.getText());
		numTempi = Integer.parseInt(tquanti.getText());
	    tempi = new int[numTempi];
	    pos = 0;
	    lcont.setText(""+contatore);

	}

	private void stampa() {
		int i , somma=0;
		double media=0;
		String s = "" ;
		for(i=0;i<numTempi;i++) {
			s=s+tempi[i]+"-";
			somma=somma+tempi[i];
		}
		media=somma/tempi.length;
		lmedia.setText(""+media);
		lelenco.setText(s);

	}

	private void inserisci() {
		if(pos < numTempi) {
	         tempi[pos++]=Integer.parseInt(tnumero.getText());
	         tnumero.setText("");
	         contatore--;
	         lcont.setText(""+contatore);
	      }

	}
	public static void main(String[]args) {
		launch(args);
	}

}
