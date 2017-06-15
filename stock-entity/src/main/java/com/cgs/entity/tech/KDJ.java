package com.cgs.entity.tech;

/**
 * Created by Administrator on 2017/6/10.
 */
public class KDJ {

  private double rsv;
  private double cn;
  private double ln;
  private double hn;
  private double currentK;
  private double currentD;
  private double currentJ;

  public double getRsv() {
    return rsv;
  }

  public void setRsv(double rsv) {
    this.rsv = rsv;
  }

  public double getCn() {
    return cn;
  }

  public void setCn(double cn) {
    this.cn = cn;
  }

  public double getLn() {
    return ln;
  }

  public void setLn(double ln) {
    this.ln = ln;
  }

  public double getHn() {
    return hn;
  }

  public void setHn(double hn) {
    this.hn = hn;
  }

  public double getCurrentK() {
    return currentK;
  }

  public void setCurrentK(double currentK) {
    this.currentK = currentK;
  }

  public double getCurrentD() {
    return currentD;
  }

  public void setCurrentD(double currentD) {
    this.currentD = currentD;
  }

  public double getCurrentJ() {
    return currentJ;
  }

  public void setCurrentJ(double currentJ) {
    this.currentJ = currentJ;
  }
}
