import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ModeleTest {
	private boolean rep,rep2;
	@Before
	public void setUp() throws Exception {
		rep = Modele.connexion();
		rep2 = Modele.deconnexion();
	}
	
	// Le but de ce test est de verifier que le modele arrive a ce connecter a la base de donnee
	@Test 
	public void testCo() {
		assertEquals("La connexion a echoué",true,rep);
	}
	
	// Le but de ce test est de verifier que la fonction qui deconnecte renvoie bien true(sous entendu que la
	// connexion est rompue)
	@Test
	public void testDeco(){
		assertEquals("La deconnection a echoué",true,rep2);
	}

}
