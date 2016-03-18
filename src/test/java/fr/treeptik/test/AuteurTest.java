package fr.treeptik.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.springframework.test.context.ContextConfiguration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Auteur;

import fr.treeptik.service.AuteurService;

/**
 * Voir assert-sum pour une liste des asserts principaux disponibles
 * 
 * @author marvin
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class AuteurTest {

	private Auteur a;

	@Autowired
	private AuteurService auteurServiceTest;

	@Before
	public void setUp() {

		a = new Auteur();
		a.setNom("Auteur1");
		a.setPrenom("prenom1");


		try {
			a = auteurServiceTest.createAuteur(a);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@After
	public void delete() {

		try {
			auteurServiceTest.delete(a.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void findOneTest() {

		Auteur auteur = new Auteur();

		try {
			auteur = auteurServiceTest.find(a.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		assertEquals(auteur, a);

	}

}
