package com.cgs.entity.tech;

public class EMA {

  private static final int N = 12;
  private double a;
  private double priceYesterday;
  private double priceToday;

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getPriceYesterday() {
    return priceYesterday;
  }

  public void setPriceYesterday(double priceYesterday) {
    this.priceYesterday = priceYesterday;
  }

  public double getPriceToday() {
    return priceToday;
  }

  public void setPriceToday(double priceToday) {
    this.priceToday = priceToday;
  }
}
