package com.jone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;

public class GetJsonData {
	public JSONArray getJsonArray( ) {
        List<EchartData> echartDataList = new ArrayList<EchartData>();
        EchartData echart = new EchartData();
        echart.setLegend("增长量");
		 //里面值填充数组 datas = new String[]{"北京","天津"....}
		 echart.setXdata(new ArrayList<String>(Arrays.asList("北京","天津","青岛","南京","上海")));
		 //里面值填充数组 datas = new Integer[]{2,7,8.....}
		 echart.setData(new ArrayList<Integer>(Arrays.asList(2,7,8,5,9)));
		 echartDataList.add(echart);
		 /*
		 JSONArray array = new JSONArray();
		 JSONObject jsonObject = null;
		 jsonObject = new JSONObject();
		 jsonObject.put("ech", echart);
		 array.add(jsonObject);
		 array.toString();
		 */
		 //将值一json格式返回
		 return JSONArray.fromObject(echartDataList);
		 
		 
		 
		// TODO Auto-generated constructor stub
	}
}
