/**
 * 
 */
package com.zhangzhi.senior2.week2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhangzhi
 *2019年10月14日
 */
public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212222778989275599L;
	/**
	 * 
	 */
	
	private int id;
	private String name;
	private  BigDecimal bi;
	private String fen;
	private int bai;
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", bi=" + bi + ", fen=" + fen + ", bai=" + bai + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBi() {
		return bi;
	}
	public void setBi(BigDecimal bi) {
		this.bi = bi;
	}
	public String getFen() {
		return fen;
	}
	public void setFen(String fen) {
		this.fen = fen;
	}
	public int getBai() {
		return bai;
	}
	public void setBai(int bai) {
		this.bai = bai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Goods(int id, String name, BigDecimal bi, String fen, int bai) {
		super();
		this.id = id;
		this.name = name;
		this.bi = bi;
		this.fen = fen;
		this.bai = bai;
	}
	public Goods() {
		super();
	}
	
	
}
