package com.parseXML;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 读取下xml文档,获得document对象。
 * TODO 递归解析XML文档
 */
public class ParseXMLByDom4j {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("m:/下载2.xml"));
        
        //节点对象的操作方法
        
        //获取文档根节点
        Element root = document.getRootElement();
        //输出根标签的名字
        System.out.println("根标签的名字:" + root.getName());
        
        
        //获取根节点下面的所有子节点（不包过子节点的子节点）
        List<Element> list = root.elements() ;
        //遍历List的方法
        for (Element e:list){
        	System.out.println("根节点下面的所有子节点（不包过子节点的子节点）↓:" );
            System.out.println("子节点1:"+e.getName());
        }
        /*
        //获得指定节点下面的子节点
        Element contactElem = root.element("contact");//首先要知道自己要操作的节点。 
        if (null == contactElem || "".equals(contactElem)) {
        	System.out.println("NULL");
			return;
		}
        List<Element> contactList = contactElem.elements();
        for (Element e:contactList){
            System.out.println(e.getName());
        }
        */
        
        //调用下面获取子节点的递归函数。
        getChildNodes(root);
        
        //获得当前标签下指定名称的第一个子标签
        Element conElem = root.element("contact");
        if (null != conElem) {
        	System.out.println(conElem.getName());
        	
        	//获得更深层次的标签（一层一层的获取）
        	Element nameElem = conElem.element("name");
        	if (null != nameElem) {
        		System.out.println(nameElem.getName());
        	}
		}
        
    }
    
    //递归查询节点函数,输出节点名称
    @SuppressWarnings("unchecked")
	private static void  getChildNodes(Element elem){
    	
    	if (null != elem.getTextTrim() && !"".equals(elem.getTextTrim())) {
    		System.out.println("节点名称:"+elem.getName()
    			+"---Value ="+elem.getTextTrim());
		}else {
			String id = elem.attributeValue("id");
			if (null != id) {
				System.out.println("节点名称:"+elem.getName() + " | ID = " + id);
			}
		}
    	
		Iterator<Node> it=    elem.nodeIterator();
        while (it.hasNext()){
            Node node = it.next();
            if (node instanceof Element){
                Element e1 = (Element)node;
                getChildNodes(e1);
            }
        }
	}
    
}
