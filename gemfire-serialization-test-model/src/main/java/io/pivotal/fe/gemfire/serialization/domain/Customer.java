package io.pivotal.fe.gemfire.serialization.domain;


import java.util.SimpleTimeZone;

/**
 * @author lshannon
 *
 */
public class Customer {
	
	private SimpleTimeZone simpleTimeZone;
	
	private String name;
	
	public SimpleTimeZone getSimpleTimeZone() {
		return simpleTimeZone;
	}
	public void setSimpleTimeZone(SimpleTimeZone simpleTimeZone) {
		this.simpleTimeZone = simpleTimeZone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
