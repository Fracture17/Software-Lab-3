import com.calculator.Calculator;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CalculatorTest.class, LexerTest.class, ParserTest.class} )
public final class AllTestsSuite {
}
