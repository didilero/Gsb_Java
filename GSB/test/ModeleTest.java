import static org.junit.Assert.*;
import modele.Modele;

import org.junit.Before;
import org.junit.Test;


public class ModeleTest {
	private boolean rep,rep2;
	boolean rep3;
	
	@Before
	public void setUp() throws Exception {
		rep = Modele.connexion();
		rep2 = Modele.deconnexion();
		rep3 = Modele.connexionUtilisateur("tgouraud", "coucou"); 
	}
	
	// Le but de ce test est de verifier que le modele arrive a ce connecter a la base de donnee
	@Test 
	public void testCo() {
		assertEquals("La connexion a echou�",true,rep);
	}
	
	// Le but de ce test est de verifier que la fonction qui deconnecte renvoie bien true(sous entendu que la
	// connexion est rompue)
	@Test
	public void testDeco(){
		assertEquals("La deconnection a echou�",true,rep2);
	}
	
	// Le but de ce test est de verifier que l'utilisateur qui est mit dedans soit bien un 
	// comptable et que les donn�es saisie soit les bonnes
	@Test
	public void testConnexionUtilisateur(){
		assertEquals("La Connexion de l'utilisateur a la base de donnee a echou�",true,rep3);
	}
	@Test
	public void testCryptage(){
		assertEquals("Le mot de passe n'est pas correctement crypt�","721a9b52bfceacc503c056e3b9b93cfa",Modele.getEncodedPassword("coucou"));
	}
	
	@Test
	public void testFicheFrais(){
		assertNotNull("La liste est vide",Modele.getFicheFrais());
	}
	
	@Test
	public void testFicheFraisHorsForfait(){
		assertNotNull("La liste est vide",Modele.getHorsForfait());
	}
	
	/*@Test
	public void testMettreAMiseRemboursement(){
		assertEquals("La mise en remboursement a echouer",true,);
	}*/
}
