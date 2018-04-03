/**
 * 
 */
package wolf_j.com.github.tdd.zipcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author wolf-J
 *
 */
/**
 * @author wolf-J
 *
 */
class BarCodeTest {

	/**
	 * Test method for
	 * {@link wolf_j.com.github.tdd.zipcode.BarCode#BarCode(java.lang.String)}.
	 */

	@Test
	void testGetValue() {

	}

	/**
	 * Test method for
	 * {@link wolf_j.com.github.tdd.zipcode.BarCode#isBarCode(java.lang.String)}.
	 * @throws Throwable 
	 */
	@Test
	@DisplayName("isBarCode(\":::|||\") == False")
	void testIsBarCode_when_given_have_not_prefix() throws Throwable {
		assertFalse(BarCode.isBarCode(":::|||"));
	}

	@Test
	@DisplayName("isBarCode(\"|:|:|::|:|:||:::||:::::||::|:|::|:|:||:::||:::::||:|\") == False")
	void testIsBarCode_when_given_a_error_validationKey_barcode() throws Throwable {
		assertFalse(BarCode.isBarCode("|:|:|::|:|:||:::||:::::||::|:|::|:|:||:::||:::::||:|"));
	}

	@Test
	@DisplayName("isBarCode(\"|:|:|::|:|:||:::||:::::||:|:::||\") == True")
	void testIsBarCode_when_given_five_number_barcode() throws Throwable {
		assertTrue(BarCode.isBarCode("|:|:|::|:|:||:::||:::::||:|:::||"));
	}

	/**
	 * Test method for
	 * {@link wolf_j.com.github.tdd.zipcode.BarCode#convertZipCodeToBarCode(wolf_j.com.github.tdd.zipcode.ZipCode)}.
	 * @throws Throwable 
	 */
	@Test
	void testConvertZipCodeToBarCode() throws Throwable {
		assertEquals("|:|:|::|:|:||:::||:::::||:|:::||", BarCode.convertZipCodeToBarCode(new ZipCode("55003")).getValue());
	}

}
