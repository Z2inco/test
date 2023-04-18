import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
class TriangleTest {
    @Test
    @DisplayName("输入错误")
    void parameters_error_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(0, 4, 5);
        assertEquals("输入错误", type);
    }
    @Test
    @DisplayName("不等边三角形")
    void scalene_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(3, 4, 6);
        assertEquals("不等边三角形", type);
    }
    @Test
    @DisplayName("等边三角形")
    void equalTri_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(3, 3, 3);
        assertEquals("等边三角形", type);
    }
    @Test
    @DisplayName("非三角形")
    void noTri_test() {
        Triangle triangle = new Triangle();
        String type = triangle.classify(3, 3, 7);
        assertEquals("非三角形", type);
    }
    @ParameterizedTest
    @CsvSource({
            "0,4,5,输入错误",
            "3,4,5,不等边三角形",
            "3,3,3,等边三角形",
            "3,3,7,非三角形",
    })

    void paramTriangle(int a,int b,int c,String expected){
        Triangle triangle = new Triangle();

        String type = triangle.classify(a,b,c);

        assertEquals(expected,type);
    }

    @DisplayName(value="三角形一般边界值测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形一般边界值测试用例.csv",numLinesToSkip =1,encoding = "GBK")
    void fileTest(int a, int b,int c,String expected) throws ParseException {

        Triangle triangle=new Triangle();

        String type = triangle.classify(a, b, c);

        assertEquals(expected, type);
    }

    @DisplayName(value="三角形健壮性边界值测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形健壮性边界值测试用例.csv",numLinesToSkip =1,encoding = "GBK")
    void fileTest1(int a, int b,int c,String expected) throws ParseException {

        Triangle triangle=new Triangle();

        String type = triangle.classify(a, b, c);

        assertEquals(expected, type);
    }

    @DisplayName(value="三角形最坏情况一般边界值测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形测试用例2.csv",numLinesToSkip =1,encoding = "GBK")
    void fileTest2(int a, int b,int c,String expected) throws ParseException {

        Triangle triangle=new Triangle();

        String type = triangle.classify(a, b, c);

        assertEquals(expected, type);
    }

    @DisplayName(value="三角形最坏情况健壮性边界值测试用例")
    @ParameterizedTest
    @CsvFileSource(resources = "/三角形测试用例2.csv",numLinesToSkip =1,encoding = "GBK")
    void fileTest3(int a, int b,int c,String expected) throws ParseException {

        Triangle triangle=new Triangle();

        String type = triangle.classify(a, b, c);

        assertEquals(expected, type);
    }


}