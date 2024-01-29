package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class maggioremedia extends Application{
	TextField tnumero = new TextField();
	TextField tquanti = new TextField();
	Label lelenco = new Label();
	Label lmedia = new Label();
	Label lcont = new Label();
	Label lmaggiori = new Label();
	Label lminori = new Label();
	int tempi[];
    int numTempi;
    int pos;
    int contatore;
    double media=0;
	
	
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
		
		Button pcalcola = new Button();
		pcalcola.setText("Calcola");
		pcalcola.setOnAction(e -> calcola());
		
		griglia.add(ltext, 0, 0);
		griglia.add(ltext1, 3, 0);
		griglia.add(tnumero, 1, 0);
		griglia.add(tquanti, 2, 0);
		griglia.add(palloca, 0, 1);
		griglia.add(pinserisci, 1, 1);
		griglia.add(pstampa, 0, 2);
		griglia.add(pcalcola, 1, 2);
		griglia.add(lelenco, 0, 3,3,3);
		griglia.add(lmedia, 0, 5);
		griglia.add(lmaggiori, 0, 6,3,6);
		griglia.add(lminori, 0, 7,3,6);
		griglia.add(lcont, 2, 1);
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
	private void calcola() {
		int i;
		String s = "" ;
		String v = "" ;
		
		for (i = 0; i < numTempi; i++) {
			if (tempi[i] > media) {
				s=s+tempi[i]+"-";
				lmaggiori.setText("Maggiori sono: " + s);
			} else {
					v=v+tempi[i]+"-";
					lminori.setText("Minori sono: " + v);
				
			}
		}

	}
	public static void main(String[]args) {
		launch(args);
	}
}
