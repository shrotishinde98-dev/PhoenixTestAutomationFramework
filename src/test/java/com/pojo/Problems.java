package com.pojo;

public class Problems {
	  private int id;
      private String remark;
	  public Problems(int id, String remark) {
		super();
		this.id = id;
		this.remark = remark;
	  }
	  public int getId() {
		  return id;
	  }
	  public void setId(int id) {
		  this.id = id;
	  }
	  public String getRemark() {
		  return remark;
	  }
	  public void setRemark(String remark) {
		  this.remark = remark;
	  }
	  @Override
	  public String toString() {
		return "Problems [id=" + id + ", remark=" + remark + ", getId()=" + getId() + ", getRemark()=" + getRemark()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	  }
      
}
