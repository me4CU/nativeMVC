package com.hibernate.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author liuming
 * 客户回访表entity
 */
@Entity
@Table(name = "T_KH_HF")
public class TKhHf implements java.io.Serializable{
	
	private String wid;		//回访表主键  
	private String khwid;	//客户管理wid
	private String hffs;	//回访方式
	private Date hfsj;	//回访时间
	private String hfzt;	//回访主题
	private String hfnr;	//回访内容
	private String hfjg;	//回访结果
	private String jlry;	//记录人员
	private Date txrq;	//填写日期
	private String cjr;	//创建人
	private Date cjsj;	//创建时间
	private String bz;	//备注
	
	// Constructors
	public TKhHf() {
		super();
	}
	
	public TKhHf(String wid) {
		super();
		this.wid = wid;
	}

	public TKhHf(String wid, String khwid, String hffs, Date hfsj, String hfzt, String hfnr, String hfjg, String jlry,
			Date txrq, String cjr, Date cjsj, String bz) {
		super();
		this.wid = wid;
		this.khwid = khwid;
		this.hffs = hffs;
		this.hfsj = hfsj;
		this.hfzt = hfzt;
		this.hfnr = hfnr;
		this.hfjg = hfjg;
		this.jlry = jlry;
		this.txrq = txrq;
		this.cjr = cjr;
		this.cjsj = cjsj;
		this.bz = bz;
	}

	@Id
	@Column(name = "WID", unique = true, nullable = false, length = 50)
	public String getWid() {
		return wid;
	}
	public void setWid(String wid) {
		this.wid = wid;
	}
	
	@Column(name = "KHWID", length = 50)
	public String getKhwid() {
		return khwid;
	}
	public void setKhwid(String khwid) {
		this.khwid = khwid;
	}
	
	@Column(name = "HFFS", length = 50)
	public String getHffs() {
		return hffs;
	}
	public void setHffs(String hffs) {
		this.hffs = hffs;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HFSJ", length = 7)
	public Date getHfsj() {
		return hfsj;
	}
	public void setHfsj(Date hfsj) {
		this.hfsj = hfsj;
	}
	
	@Column(name = "HFZT", length = 50)
	public String getHfzt() {
		return hfzt;
	}
	public void setHfzt(String hfzt) {
		this.hfzt = hfzt;
	}
	
	@Column(name = "HFNR", length = 50)
	public String getHfnr() {
		return hfnr;
	}
	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}
	
	@Column(name = "HFJG", length = 50)
	public String getHfjg() {
		return hfjg;
	}
	public void setHfjg(String hfjg) {
		this.hfjg = hfjg;
	}
	
	@Column(name = "JLRY", length = 50)
	public String getJlry() {
		return jlry;
	}
	public void setJlry(String jlry) {
		this.jlry = jlry;
	}
	
	@Column(name = "CJR", length = 50)
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	
	@Column(name = "BZ", length = 50)
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TXRQ", length = 7)
	public Date getTxrq() {
		return txrq;
	}
	public void setTxrq(Date txrq) {
		this.txrq = txrq;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CJSJ", length = 7)
	public Date getCjsj() {
		return cjsj;
	}
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	
	@Override
	public String toString() {
		return "TKhHf [wid=" + wid + ", khwid=" + khwid + ", hffs=" + hffs + ", hfsj=" + hfsj + ", hfzt=" + hfzt
				+ ", hfnr=" + hfnr + ", hfjg=" + hfjg + ", jlry=" + jlry + ", txrq=" + txrq + ", cjr=" + cjr + ", cjsj="
				+ cjsj + ", bz=" + bz + "]";
	}
	
}
