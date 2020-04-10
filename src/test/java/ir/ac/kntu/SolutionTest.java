/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SolutionTest {

    @Test
    public void testAMethod1() {
        assertEquals("A1", new A().method1());
    }

    @Test
    public void testAMethod2() {
        assertEquals("A2", new A().method2());
    }

    @Test
    public void testBMethod1() {
        assertEquals("A1",
                new B().method1());
    }

    @Test
    public void testBMethod2() {
        assertEquals("A1B2", new B().method2());
    }

    @Test
    public void testCMethod1() {
        assertEquals("C1", new C().method1());
    }

    @Test
    public void testCMethod2() {
        assertEquals("C1B2", new C().method2());
    }

    @Test
    public void testDMethod1() {
        assertEquals("D1", new D().method1());
    }

    @Test
    public void testDMethod2() {
        assertEquals("D1B2", new D().method2());
    }
    @Test
    public void testInheritance1() throws ClassNotFoundException {
        Class<?> b = Class.forName("ir.ac.kntu.B");
        Class<?> c = Class.forName("ir.ac.kntu.C");
        Class<?> d = Class.forName("ir.ac.kntu.D");
        assertTrue(b.isAssignableFrom(d));
        assertTrue(b.isAssignableFrom(c));
    }

    @Test
    public void testInheritance2() throws ClassNotFoundException {
        Class<?> a = Class.forName("ir.ac.kntu.A");
        Class<?> b = Class.forName("ir.ac.kntu.B");
        Class<?> c = Class.forName("ir.ac.kntu.C");
        Class<?> d = Class.forName("ir.ac.kntu.D");
        assertTrue(a.isAssignableFrom(b));
        assertTrue(a.isAssignableFrom(c));
        assertTrue(a.isAssignableFrom(d));
    }

    @Test
    public void testAMethods() throws ClassNotFoundException {
        Class<?> a = Class.forName("ir.ac.kntu.A");
        Method[] methods = a.getDeclaredMethods();
        assertEquals(2, methods.length);
        boolean hasMethod1 = false;
        boolean hasMethod2 = false;
        for (int i = 0; i < 2; i++) {
            if ("method1".equals(methods[i].getName())) {
                hasMethod1 = true;
                assertEquals("class java.lang.String", methods[i].getReturnType().toString());
            } else if ("method2".equals(methods[i].getName())) {
                hasMethod2 = true;
                assertEquals("class java.lang.String", methods[i].getReturnType().toString());
            }
        }
        assertTrue(hasMethod1);
        assertTrue(hasMethod2);
    }

    @Test
    public void testBMethods() throws ClassNotFoundException {
        Class<?> b = Class.forName("ir.ac.kntu.B");
        Method[] methods = b.getDeclaredMethods();
        assertEquals(1, methods.length);
        assertEquals("method2", methods[0].getName());
        assertEquals("class java.lang.String", methods[0].getReturnType().toString());
    }

    @Test
    public void testCMethods() throws ClassNotFoundException {
        Class<?> a = Class.forName("ir.ac.kntu.C");
        Method[] methods = a.getDeclaredMethods();
        assertEquals(1, methods.length);
        assertEquals("method1", methods[0].getName());
        assertEquals("class java.lang.String", methods[0].getReturnType().toString());
    }

    @Test
    public void testDMethods() throws ClassNotFoundException {
        Class<?> d = Class.forName("ir.ac.kntu.D");
        Method[] methods = d.getDeclaredMethods();
        assertEquals(1, methods.length);
        assertEquals("method1", methods[0].getName());
        assertEquals("class java.lang.String", methods[0].getReturnType().toString());

    }

    @Test
    public void testAFields() throws ClassNotFoundException {
        Class<?> a = Class.forName("ir.ac.kntu.A");
        assertEquals(0, a.getDeclaredFields().length);
    }

    @Test
    public void testBFields() throws ClassNotFoundException {
        Class<?> b = Class.forName("ir.ac.kntu.B");
        assertEquals(0, b.getDeclaredFields().length);
    }

    @Test
    public void testCFields() throws ClassNotFoundException {
        Class<?> c = Class.forName("ir.ac.kntu.C");
        assertEquals(0, c.getDeclaredFields().length);
    }

    @Test
    public void testDFields() throws ClassNotFoundException {
        Class<?> d = Class.forName("ir.ac.kntu.D");
        assertEquals(0, d.getDeclaredFields().length);
    }

}
