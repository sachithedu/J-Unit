package com.comp301.a04junit;

import com.comp301.a04junit.adept.Item;
import com.comp301.a04junit.adept.ItemImpl;
import com.comp301.a04junit.jedi.Player;

import org.junit.Test;
import static org.junit.Assert.*;

public class JediPlayerTests {

  @Test
  public void testName() {
    Player name = new Player("Sachith");
    assertTrue(name.getName().equals("Sachith"));
  }

  @Test
  public void testIntialValues() {
    Player name = new Player("Sachith");
    assertTrue(name.getName().equals("Sachith"));
    assertEquals(10, name.getCapacity());
    assertEquals(0, name.getLocX());
    assertEquals(0, name.getLocY());
    assertEquals(0, name.getNumItems());
  }

  @Test
  public void testExceededCapacity() {
    Player name = new Player("Sachith");
    Item item = new ItemImpl("item");
    for (int i = 0; i < 10; i++) {
      name.addItem(item);
    }
    try {
      name.addItem(item);
    }
    catch(RuntimeException e) {
      e.printStackTrace();
    }
    assertFalse(name.getNumItems() > name.getCapacity());
  }

  @Test
  public void testRemoveItem() {
    Item itemA = new ItemImpl("itemA");
    Item itemB = new ItemImpl("itemB");
    Item itemC = new ItemImpl("itemC");

    Item[] list = {itemA, itemB, itemC};

    Player name = new Player("Sachith");
    for (int i = 0; i < 3; i++) {
      name.addItem(list[i]);
    }
    name.removeItem(itemA);
    assertFalse(name.hasItem(itemA));
  }

  @Test
  public void testRemoveItemIndex() {
    Item itemA = new ItemImpl("itemA");
    Item itemB = new ItemImpl("itemB");
    Item itemC = new ItemImpl("itemC");

    Item[] list = {itemA, itemB, itemC};

    Player name = new Player("Sachith");
    for (int i = 0; i < 3; i++) {
      name.addItem(list[i]);
    }
    assertEquals(itemB, name.removeItem(1));
  }


  @Test
  public void testAddItem() {
    Player name = new Player("Sachith");
    Item item = new ItemImpl("item");
    name.addItem(item);
    assertTrue(name.hasItem(item));
  }

  @Test
  public void testHasItem() {
    Player name = new Player("Sachith");
    Item itemA = new ItemImpl("itemA");
    Item itemB = new ItemImpl("itemB");
    name.addItem(itemA);
    assertFalse(name.hasItem(itemB));
  }


  @Test
  public void testNumItems() {
    Player name = new Player("Sachith");
    Item item = new ItemImpl("item");
    try {
      for (int i = 0; i < 11; i++) {
        name.addItem(item);
      }
    }
    catch(RuntimeException e) {
    }
    finally {
      assertFalse(name.getNumItems() < name.getCapacity());

    }
  }
  @Test
  public void testMoveNorth() {
    Player name = new Player("Sachith");
    int y = 0;
    name.moveNorth();
    name.moveNorth();
    name.moveNorth();
    y+=3;
    assertEquals(y, name.getLocY());
  }

  @Test
  public void testMoveSouth() {
    Player name = new Player("Sachith");
    int y = 0;
    name.moveSouth();
    name.moveSouth();
    name.moveSouth();
    y-=3;
    assertEquals(y, name.getLocY());
  }

  @Test
  public void testMoveEast() {
    Player name = new Player("Sachith");
    int x = 0;
    name.moveEast();
    name.moveEast();
    name.moveEast();
    x+=3;
    assertEquals(x, name.getLocX());
  }

  @Test
  public void testMoveWest() {
    Player name = new Player("Sachith");
    int x = 0;
    name.moveWest();
    name.moveWest();
    name.moveWest();
    x-=3;
    assertEquals(x, name.getLocX());
  }


}
