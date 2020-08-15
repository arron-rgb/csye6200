package edu.neu.csye6200;

import static edu.neu.csye6200.Commons.ALPHABET;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author arronshentu
 */
public class PartOne {
  private static final Lock LOCK = new ReentrantLock();
  private static final Condition CONDITION = LOCK.newCondition();

  private static final ExecutorService PRINTER_SERVICE = Executors.newFixedThreadPool(2);

  public static void demo() {
    List<Object> chars = new ArrayList<>();
    for (char c : ALPHABET.toCharArray()) {
      chars.add(c);
    }
    for (Object alpha : chars) {
      PRINTER_SERVICE.submit(new LowerCasePrinter(alpha));
      PRINTER_SERVICE.submit(new UpperCasePrinter(alpha));
    }

    // in order to wait all tasks are submitted
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // quit lock state
    LOCK.lock();

    try {
      CONDITION.signalAll();
      PRINTER_SERVICE.shutdown();
    } finally {
      LOCK.unlock();
    }
  }

  private static abstract class AbstractPrinter implements Runnable {
    protected Object content;

    public AbstractPrinter(Object content) {
      this.content = content;
    }

    @Override
    public void run() {
      if (content == null) {
        System.out.println("empty content");
      }
      LOCK.lock();
      try {
        CONDITION.signal();
        print();
        CONDITION.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        LOCK.unlock();
      }
    }

    /**
     * print content
     */
    abstract void print();
  }

  private static class LowerCasePrinter extends AbstractPrinter {

    public LowerCasePrinter(Object content) {
      super(content);
    }

    @Override
    public void run() {
      super.run();
    }

    @Override
    void print() {
      System.out.print(content.toString().toLowerCase());
    }

  }

  private static class UpperCasePrinter extends AbstractPrinter {

    public UpperCasePrinter(Object content) {
      super(content);
    }

    @Override
    public void run() {
      super.run();
    }

    @Override
    void print() {
      System.out.print(content.toString().toUpperCase());
    }

  }
}
