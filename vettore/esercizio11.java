package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class esercizio11 extends Application{
	TextField tnumero = new TextField();
	Label lstring = new Label();
	Label lris = new Label();
	Label ltext1 = new Label("Numeri separati  ,");
    int contatore;
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Label ltext = new Label("Inserisci numeri: ");
		
		Button pcalcola = new Button();
		pcalcola.setText("Calcola");
		pcalcola.setOnAction(e -> calcola());
			
		griglia.add(ltext, 0, 0);
		griglia.add(ltext1, 0, 1);
		griglia.add(tnumero, 1, 0);
		griglia.add(pcalcola, 0, 2);
		griglia.add(lstring, 0, 4);
		griglia.add(lris, 0, 5);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia,300,300);
		finestra.setScene(scena);
		finestra.setTitle(" Valore Minimo");
		finestra.show();
	}

	private void calcola() {

		String v = tnumero.getText();
		String tempi[] = v.split(",");
		
		int[] numeri = new int[tempi.length];
		
		int min=0,max;
		int indice = 0;
		
		String s = "";
		
		for(int i=0; i < numeri.length; i++) {
			int n = Integer.parseInt(tempi[i]);
			numeri[i] = n;
			max=numeri[i];
			if (numeri[i] < max) {
				min = numeri[i];
				indice = i;
			}
			s+=numeri[i] + " - ";
		}
		lstring.setText(s);
		lris.setText("Elemento minimo: "+ min+" di posizione:  "+indice);
	}
	public static void main(String[]args) {
		launch(args);
	}

}

