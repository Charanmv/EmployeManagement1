package com.employe.model;

public class Mysqlinfo {
	
	private String JDBC_URL;
	private String USERNAME;
	private String PASSWORD;
	public Mysqlinfo() {
		super();
	}
	public Mysqlinfo(String jDBC_URL, String uSERNAME, String pASSWORD) {
		super();
		JDBC_URL = jDBC_URL;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
	}
	public String getJDBC_URL() {
		return JDBC_URL;
	}
	public void setJDBC_URL(String jDBC_URL) {
		JDBC_URL = jDBC_URL;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	@Override
	public String toString() {
		return "Mysqlinfo [JDBC_URL=" + JDBC_URL + ", USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + "]";
	}
	

}
