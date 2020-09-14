package com.cloud.leetcode.fizz.bizz.whizz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void should_return_fizz_when_number_is_3() {
        Student student = new Student(3);
        assertThat(student.report(), is("fizz"));
    }

    @Test
    public void should_return_buzz_when_number_is_5() {
        Student student = new Student(5);
        assertThat(student.report(), is("buzz"));
    }

    @Test
    public void should_return_whizz_when_number_is_7() {
        Student student = new Student(7);
        assertThat(student.report(), is("whizz"));
    }

    @Test
    public void should_return_fizz_buzz_when_number_is_15() {
        Student student = new Student(15);

        assertThat(student.report(), is("fizzbuzz"));
    }

    @Test
    public void should_return_buzz_whizz_when_number_is_35() {
        Student student = new Student(35);

        assertThat(student.report(),is("buzzwhizz"));
    }

    @Test
    public void should_return_fizz_whizz_when_number_is_21() {
        Student student = new Student(21);

        assertThat(student.report(),is("fizzwhizz"));
    }

    @Test
    public void should_return_fizz_buzz_whizz_when_number_is_105() {
        Student student = new Student(105);

        assertThat(student.report(), is("fizzbuzzwhizz"));
    }

    @Test
    public void should_return_fizzfizz_when_number_is_33() {
        Student student = new Student(33);

        assertThat(student.report(), is("fizz"));
    }
}
