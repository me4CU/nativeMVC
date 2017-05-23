package com.jone;

import java.util.List;

public class EchartData {
	private String legend;

    private List<String> xdata;

    private List<Integer> data;

    public EchartData(){}
    
	public EchartData(String legend, List<String> xdata, List<Integer> data) {
		super();
		this.legend = legend;
		this.xdata = xdata;
		this.data = data;
	}


	@Override
	public String toString() {
		return "EchartData [legend=" + legend + ", xdata=" + xdata + ", data=" + data + "]";
	}


	public List<String> getXdata() {
		return xdata;
	}

	public void setXdata(List<String> xdata) {
		this.xdata = xdata;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public String getLegend() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}
    
}
