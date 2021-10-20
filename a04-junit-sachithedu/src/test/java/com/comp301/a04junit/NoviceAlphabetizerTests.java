package com.comp301.a04junit;

import com.comp301.a04junit.novice.Alphabetizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class NoviceAlphabetizerTests {

  @Test
  public void testConstructorNull() {
    Alphabetizer alpha = new Alphabetizer(null);
    // assertEquals(null, alpha);
  }

  @Test
  public void testConstructorCapitalize() {
    String[] arr = {"a1", "B1"};
    Alphabetizer alpha = new Alphabetizer(arr);
    assertEquals("B1", alpha.next());
  }

  @Test
  public void testConstructorMixedArr() {
    String[] arr = {"c1", "a1", "b1"};
    // Check with clone
    String[] clone = arr.clone();
    Alphabetizer alpha = new Alphabetizer(arr);
    alpha.next();
    alpha.next();
    assertTrue(Arrays.equals(arr, clone));

  }

  @Test
  public void testNext() {
    String[] arr = {"b1", "c1", "a1"};
    Alphabetizer alpha = new Alphabetizer(arr);
    String val = alpha.next();
    assertEquals("a1", val);
    val = alpha.next();
    assertEquals("b1", val);
    val = alpha.next();
    assertEquals("c1", val);
  }

  @Test
  public void testException() {
    String[] arr = {"a1"};
    Alphabetizer alpha = new Alphabetizer(arr);
    alpha.next();
    String val;
    try {
      val = alpha.next();
    }
    catch (NoSuchElementException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testNoHasNext() {
    String[] arr = {"a1"};
    Alphabetizer alpha = new Alphabetizer(arr);
    alpha.next();
    try {
      alpha.next();
    }
    catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    finally {
      assertFalse(alpha.hasNext());
    }
  }

  @Test
  public void testHasNext() {
    String[] arr = {"a1", "b1"};
    Alphabetizer alpha = new Alphabetizer(arr);
    alpha.next();
    assertTrue(alpha.hasNext());
  }

}

