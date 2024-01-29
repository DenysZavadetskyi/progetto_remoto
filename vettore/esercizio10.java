package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class esercizio10 extends Application{
	TextField tnumero = new TextField();
	TextField tmin = new TextField();
	TextField tquanti = new TextField();
	Label lstring = new Label();
	Label lris = new Label();
	int tempi[];
    int numTempi;
    int pos;
    int contatore;
    int random ;
    int Max=0;
    int posizione;
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label ltext = new Label("Numero massimo");
		Label ltext1 = new Label("Quanti");
		Label ltext2 = new Label("Numero minimo");
		
		
		Button pcalcola = new Button();
		pcalcola.setText("Calcola");
		pcalcola.setOnAction(e -> calcola());
		
		Button priempi = new Button();
		priempi.setText("Riempi");
		priempi.setOnAction(e -> riempi());
		
		
		griglia.add(ltext, 0, 0);
		griglia.add(tnumero, 1, 0);
		griglia.add(ltext1, 0, 1);
		griglia.add(ltext2, 2, 0);
		griglia.add(tmin, 3, 0);
		griglia.add(tquanti, 1, 1);
		griglia.add(pcalcola, 0, 2);
		griglia.add(priempi, 0, 3);
		griglia.add(lstring, 0, 4);
		griglia.add(lris, 0, 5);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia,300,300);
		finestra.setScene(scena);
		finestra.setTitle(" Valore Massimo");
		finestra.show();
	}
	private void riempi() {
		numTempi = Integer.parseInt(tquanti.getText());
		int num = Integer.parseInt(tnumero.getText());
		int min = Integer.parseInt(tmin.getText());
		tempi = new int[numTempi];
		for(int z= 0;z<numTempi;z++) {
			tempi[z]= (int)(Math.random()*(num+1-min)+min);
		}
	}

	private void calcola() {
		int i;
		String s = "" ;
		for(i=0;i<numTempi;i++) {
			if(Max<tempi[i]) {
				Max=tempi[i];
				posizione=i;
			}
			s=s+tempi[i]+"-";

		}
		lstring.setText(s);
		lris.setText("Elemento massimo: "+ Max+" di posizione:  "+posizione);
	}
	public static void main(String[]args) {
		launch(args);
	}

}

