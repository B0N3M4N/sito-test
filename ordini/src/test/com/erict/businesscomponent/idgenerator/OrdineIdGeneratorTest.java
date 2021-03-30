package test.com.erict.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.erict.architecture.dao.DAOException;
import com.erict.businesscomponent.idgenerator.OrdineIdGenerator;

class OrdineIdGeneratorTest {

	@Test
	void testIdGen() {
		try {
			OrdineIdGenerator idGen = OrdineIdGenerator.getInstance();
			assertNotNull(idGen);
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() -1);
		} catch(ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("Il generatore id non funziona");
		}
	}

}
