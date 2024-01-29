package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class somma1 extends Application{
	TextField tnumero = new TextField();
	TextField tquanti = new TextField();
	Label lstring = new Label();
	Label lris = new Label();
	ComboBox<String> combo = new ComboBox<>();
	int tempi[];
    int numTempi;
    int pos;
    int contatore;
    int random ;
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label ltext = new Label("Numero");
		Label ltext1 = new Label("Quanti");
		
		
		Button pcalcola = new Button();
		pcalcola.setText("Calcola");
		pcalcola.setOnAction(e -> calcola());
		
		Button priempi = new Button();
		priempi.setText("Riempi");
		priempi.setOnAction(e -> riempi());
		
		combo.getItems().add("+");
		combo.getItems().add("-");
		combo.getItems().add("*");
		combo.getSelectionModel().select(0);
		
		griglia.add(ltext, 0, 0);
		griglia.add(tnumero, 1, 0);
		griglia.add(ltext1, 0, 1);
		griglia.add(tquanti, 1, 1);
		griglia.add(combo, 1, 2);
		griglia.add(pcalcola, 0, 2);
		griglia.add(priempi, 0, 3);
		griglia.add(lstring, 0, 4,2,1);
		griglia.add(lris, 0, 5);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia,300,300);
		finestra.setScene(scena);
		finestra.setTitle("Somma");
		finestra.show();
	}
	private void riempi() {
		numTempi = Integer.parseInt(tquanti.getText());
		int num = Integer.parseInt(tnumero.getText());
		tempi = new int[numTempi];
		for(int z= 0;z<numTempi;z++) {
			tempi[z]= (int)(Math.random()*num);
		}
	}

	private void calcola() {
		int i;
		int somma;
		String s = "" ;
		String x = "";
		String primo = combo.getValue();
		x=primo;
		switch (x) {
		case "+":
			somma=0;
			for(i=0;i<numTempi;i++) {
				somma=somma+tempi[i];
				s=s+tempi[i]+"-";
				lstring.setText(s);
				
			}
			lris.setText("Risultato: "+somma);
			break;
		case "-":
			somma=0;
			for(i=0;i<numTempi;i++) {
				somma=somma-tempi[i];
				s=s+tempi[i]+"-";
				lstring.setText(s);
			}
			lris.setText("Risultato: "+somma);
			break;
		case "*":
			somma=1;
			for(i=0;i<numTempi;i++) {
				somma=somma*tempi[i];
		
				s=s+tempi[i]+"-";
				lstring.setText(s);
			}
			lris.setText("Risultato: "+somma);
			break;
		}
	}
	public static void main(String[]args) {
		launch(args);
	}

}
