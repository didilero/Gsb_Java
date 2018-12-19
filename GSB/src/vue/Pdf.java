package vue;
// http://www.jmdoudoux.fr/java/dej/chap-generation-documents.htm#generation-documents-2
//voir ce site
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import class_bdd.FicheFrais;
import class_bdd.LigneFraisForfait;

import com.itextpdf.awt.geom.Point;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf {
	private Font font;
	private static FicheFrais fiche;
	private static ArrayList<LigneFraisForfait> lignefrais;
	
	public Pdf(FicheFrais fiche, ArrayList<LigneFraisForfait> lignefrais){
		
		//On recupere les infos pour les fficher dans le pdf
		this.fiche = fiche;
		this.lignefrais = lignefrais;
		
		
		//Création d'un document pdf
		Document document = new Document(PageSize.A4.rotate());
		try {
			//Création d'un fichier CompteRenduFicheFrais.pdf
			PdfWriter.getInstance(document, new FileOutputStream("P:/gitGsb/GSB/pdf/CompteRenduFicheFrais-"+fiche.getIdVisiteur()+"-"+fiche.getMois()+".pdf"));
			
			//Qui a pour titre 
			document.addTitle("GSB: Fiche de Frais");
			
			//A partir de ce moment on ne peut plus creer de metadonne comme le nom du titre la date, ...
			//On ouvre le document pour ecrire dedans
			document.open();
			
			//Création des fonts pour la police
			this.font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLUE);
			Font fontPara = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
			
			// La classe Chunk encapsule une portion de texte du document affiché avec une certaine police de caractères.
			//C'est la plus petite unité de texte utilisable.
			Chunk chunk = new Chunk("Récapitulatif fiche de frais validée :\n", this.font);
			
			//Ajout d'une image
			Image img = Image.getInstance("P:/gitGsb/GSB/logo1.jpg");
			
			//La classe Phrase encapsule une série d'objets de type Chunk qui forme une ou plusieurs lignes dont l'espacement est défini.
			Phrase phrase = new Phrase();
			//definition de l'espacement entre les ligne
			phrase.setLeading(20f);
			phrase.add(new Chunk("Vous trouverez dans ce récapitulatif la liste des frais et frais hors forfaits "
					+ "engagés pour cette fiche de frais.\n \n",fontPara));
			
			//création d'un paragraphe qui regroupe des chunks et des phrases
			Paragraph par1 = new Paragraph(phrase);
			
			Paragraph par2 = new Paragraph(new Phrase("Veuillez vous referer au comptable en cas de probleme avec un recapitulatif de fiche de frais."));
			
			//Ajout des different element dans le document
			document.add(img);
			document.add(chunk);
			document.add(par1);
			document.add(Pdf.premierTableau());
			document.add(par2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Ferme le document
		document.close();
	}
	//Classe permmettant de déssiner un tableau.
	  public static PdfPTable premierTableau()
	  {
	      //On créer un objet table dans lequel on intialise ça taille.
	      PdfPTable table = new PdfPTable(5);
	     
	      //On créer l'objet cellule.
	      PdfPCell cell;
	      cell = new PdfPCell(new Phrase("Fiche de frais de "+fiche.getIdVisiteur()+ " effectuée le "+fiche.getMois()));
	      cell.setColspan(3);
	      table.addCell(cell);
	 
	      for(int i =0;i<lignefrais.size();i++){
		      //contenu du tableau.
		      table.addCell(lignefrais.get(i).getIdFraisForfait());
		      table.addCell(" "+lignefrais.get(i).getQuantite()+" ");
	      }
	      
	      return table;  
	  }
}
