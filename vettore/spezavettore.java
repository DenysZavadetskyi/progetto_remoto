package it.edu.iisgubbio.vettore;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class spezavettore extends Application{
	TextField tnumero = new TextField();
	Label lstring = new Label();
	Label lris = new Label();
	Label lris1 = new Label();
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
		griglia.add(lris1, 0, 6);
		griglia.setAlignment(Pos.CENTER);
		griglia.setHgap(5); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia,300,300);
		finestra.setScene(scena);
		finestra.setTitle(" Spezza Vettore ");
		finestra.show();
	}

	private void calcola() {

		String v = tnumero.getText();
		String tempi[] = v.split(",");
		int numeri[] = new int[tempi.length];
		int vettore[] = new int[tempi.length];
		int vettore1[] = new int[tempi.length];
		boolean posV = true;
		String s = "";
		String v1 ="";
		String v2 ="";
		int i1=0 , i2=0;

		for (int i = 0; i < tempi.length; i++) {
			numeri[i] = Integer.parseInt(tempi[i]);
			s += numeri[i] + " - ";
		}
		for (int i=1; i<numeri.length-1;i++) {
			if(numeri[i]>numeri[i-1]) {
				if(posV == true) {
			    i1=i;
				vettore[i1]=numeri[i-1];
				v1 += vettore[i1]+"-";
				}
			}else {
				i2 = i;
				vettore1[i2]=numeri[i-1];
				v2 += vettore1[i2]+"-";
				}else {
				if(posV==true) {
					i2++;
					vettore2[i2]=numeri[i];
				}
			}
			lstring.setText(s);
		}
		lris.setText("Vettore uno:"+ v1);
		lris1.setText("Vettore due:" + v2);
	}

	public static void main(String[] args) {
		launch(args);
	}

}