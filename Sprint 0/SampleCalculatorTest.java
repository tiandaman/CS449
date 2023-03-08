import jdk.dynalink.support.SimpleRelinkableCallSite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleCalculatorTest {

    @Test
    void twoPlusTwoShouldEqualFour(){
        SampleCalculator calculator = new SampleCalculator();
        assertEquals(4,calculator.add(2,2));
    }

    @Test
    void threePlusSevenShouldEqualTen(){
        SampleCalculator calculator = new SampleCalculator();
        assertEquals(10,calculator.add(3,7));
    }


}