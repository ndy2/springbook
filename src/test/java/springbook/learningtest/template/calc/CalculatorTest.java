package springbook.learningtest.template.calc;

import org.junit.jupiter.api.Test;
import springbook.learningtest.template.calc.v1.CalculatorV1;
import springbook.learningtest.template.calc.v2.CalculatorV2;
import springbook.learningtest.template.calc.v3.CalculatorV3;
import springbook.learningtest.template.calc.v4.CalculatorV4;
import springbook.learningtest.template.calc.v5.CalculatorV5;
import springbook.learningtest.template.calc.v6.CalculatorV6;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {

    String filepath = "C:\\Users\\1\\Desktop\\springbook\\src\\main\\java\\springbook\\learningtest\\template\\calc\\numbers.txt";

    @Test
    void CalcTestV1() throws IOException {
        CalculatorV1 calculator = new CalculatorV1();
        int sum = calculator.calcSum(filepath);

        assertThat(sum).isEqualTo(10);
    }

    @Test
    void CalcTestV2() throws IOException {
        CalculatorV2 calculator = new CalculatorV2();
        int sum = calculator.calcSum(filepath);

        assertThat(sum).isEqualTo(10);
    }

    @Test
    void CalTestV3() throws IOException {
        CalculatorV3 calculator = new CalculatorV3();
        int sum = calculator.calcSum(filepath);

        assertThat(sum).isEqualTo(10);
    }

    @Test
    void CalTestV4() throws IOException {
        CalculatorV4 calculator = new CalculatorV4();
        int sum = calculator.calcSum(filepath);
        int mul = calculator.calcMul(filepath);

        assertThat(sum).isEqualTo(10);
        assertThat(mul).isEqualTo(24);
    }

    @Test
    void CalTestV5() throws IOException {
        CalculatorV5 calculator = new CalculatorV5();
        int sum = calculator.calcSum(filepath);
        int mul = calculator.calcMul(filepath);

        assertThat(sum).isEqualTo(10);
        assertThat(mul).isEqualTo(24);
    }

    @Test
    void CalTestV6() throws IOException {
        CalculatorV6 calculator = new CalculatorV6();
        String concat = calculator.concat(filepath);

        assertThat(concat).isEqualTo("1234");
    }

}