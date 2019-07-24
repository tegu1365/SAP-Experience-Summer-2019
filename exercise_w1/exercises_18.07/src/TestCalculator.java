import org.junit.Test;
import junit.framework.*;

public class TestCalculator {
	// add
	@Test
	public void calculatorAddTest() {
		Assert.assertEquals(5.0, Calculator.add(2, 3));
	}

	@Test
	public void calculatorAddTestExpectTrue() {
		Assert.assertTrue(Calculator.add(2000000000, 3) == 2000000003);
	}

	@Test
	public void calculatorAddTestExpectFalse() {
		Assert.assertFalse(Calculator.add(-2000000000, 3) == -2000000003);
	}

	// sub
	@Test
	public void calculatorSubTest() {
		Assert.assertEquals(5.0, Calculator.sub(10, 5));
	}

	@Test
	public void calculatorSubTestExpectTrue() {
		Assert.assertTrue(5000000 == Calculator.sub(10000000, 5000000));
	}

	@Test
	public void calculatorSubTestExpectFalse() {
		Assert.assertFalse(100000000 == Calculator.sub(10000000, -50000000));
	}

	// dev
	@Test
	public void calculatorDevTest() {
		Assert.assertEquals(5.0, Calculator.dev(25, 5));
	}

	@Test
	public void calculatorDevTestExpectTrue() {
		Assert.assertTrue(2 == Calculator.dev(10000000, 5000000));
	}

	@Test
	public void calculatorDevTestExpectFalse() {
		Assert.assertFalse(-0.5 == Calculator.dev(10000000, -50000000));
	}

	// multi
	@Test
	public void calculatorMultiTest() {
		Assert.assertEquals(5.0, Calculator.multi(2.5, 2));
	}

	@Test
	public void calculatorMultiTestExpectTrue() {
		Assert.assertTrue(50000000 == Calculator.multi(10, 5000000));
	}

	@Test
	public void calculatorMultiTestExpectFalse() {
		Assert.assertFalse(10000000 * (-50000000) == Calculator.multi(10000000, -50000000));
	}
}
