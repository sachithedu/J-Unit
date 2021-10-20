package com.comp301.a04junit;

import com.comp301.a04junit.adept.Item;
import com.comp301.a04junit.adept.ItemImpl;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdeptItemTests {

  @Test
  public void unitTest1() {
    String itemVal = "A";
    ItemImpl item = new ItemImpl(itemVal);
    assertEquals(itemVal, item.getName());
  }
  @Test
  public void unitTest2() {
    ItemImpl itemOne = new ItemImpl("A");
    Item itemTwo = null;
    assertFalse(itemOne.equals(itemTwo));

  }
  @Test
  public void unitTest3() {
    ItemImpl itemOne = new ItemImpl("A");
    ItemImpl itemTwo = new ItemImpl("A");
    assertTrue(itemOne.equals(itemTwo));
  }
  @Test
  public void unitTest4() {
    ItemImpl itemOne = new ItemImpl("A");
    ItemImpl itemTwo = new ItemImpl("B");
    assertFalse(itemOne.equals(itemTwo));
  }
}
