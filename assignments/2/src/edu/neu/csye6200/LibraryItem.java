package edu.neu.csye6200;

import java.io.Serializable;

/**
 * @author arronshentu
 */
public class LibraryItem extends AbstractLibraryMaterialAPI implements Serializable {

  private static final long serialVersionUID = 12364678123L;
  private static final String SPLIT_DEFAULT = ",";

  private int id;
  private String title;
  private String author;
  private String category;
  private String subject;
  private String isbn;
  private double price;

  public LibraryItem(String serializableString) {
    String[] values = serializableString.split(SPLIT_DEFAULT);
    this.id = Integer.parseInt(values[0]);
    this.category = values[1];
    this.title = values[2];
    this.author = values[3];
    this.subject = values[4];
    this.isbn = values[5];
    this.price = Double.parseDouble(values[6]);
  }

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    // #1 [BOOK] $2.49 'My Chosen Career' by Daniel Peters Non-Fiction ISBN-13: 212-217237718-7
    return String.format("#%s [%s] $%s '%s' by %s %s ISBN-13: %s", id, category, price, title, author, subject, isbn);
  }

  public int reverseAuthorSort(AbstractLibraryMaterialAPI someOtherItem) {
    /**
     * Default order is by PRICE
     */
    return someOtherItem.getAuthor().compareToIgnoreCase(this.getAuthor());
  }
}
