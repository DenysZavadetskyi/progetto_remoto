package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class esercizio17 extends Application{
	TextField tnumero = new TextField();
	TextField tk = new TextField();
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
		griglia.add(tk, 2, 0);
		griglia.add(pcalcola, 0, 2);
		griglia.add(lstring, 0, 4);
		griglia.add(lris, 0, 5);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia,300,300);
		finestra.setScene(scena);
		finestra.setTitle(" Esercizio 17 ");
		finestra.show();
	}

	private void calcola() {

		String v = tnumero.getText();
		String tempi[] = v.split(",");
		int k = Integer.parseInt(tk.getText());
		int numeri[] = new int[tempi.length];
		String s = "";
		boolean fine=false;

		for (int i = 0; i < tempi.length; i++) {
			numeri[i] = Integer.parseInt(tempi[i]);
			s += numeri[i] + " - ";
		}
		for (int i = 0; i < numeri.length && fine==false; i++) {

			if (numeri[i] < k) {
				fine=true;
			} else {

			}
			if (fine == false) {
				lris.setText("Non tutti sono minori di k = " + k);
			} else {
				
				lris.setText("Valore minore di k: " + numeri[i]);
			}

		}
		lstring.setText(s);
	}

	public static void main(String[] args) {
		launch(args);
	}

}




