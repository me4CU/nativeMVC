package com.parseXML;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * @author JoneM
 * TODO 解析XML文件
 */
public class ParseXML {

	public  ParseXML() throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
		DocumentBuilder dombuilder=domfac.newDocumentBuilder();
		InputStream is=new FileInputStream("m:/下载.xml");
		Document doc=dombuilder.parse(is);
		Element root=doc.getDocumentElement();
		NodeList books=root.getChildNodes();
		if(books!=null){
			System.out.println(books.getLength());
			for(int i=0;i<books.getLength();i++){
				Node book=books.item(i);
				int p=0;//用来控制读取object标签时循环多次的问题
				for(Node node=book.getFirstChild();node!=null;node=node.getNextSibling()){//循环读取出xml里面的内容
					
				//------------------------------------------------------------------------------	
					if(book.getNodeName().equals("fields")){
						NodeList nl=book.getChildNodes();
						for(int j=0;j<nl.getLength();j++){
							Node childNode = (Node) nl.item(j);
							Element childElement = (Element) childNode;
							System.out.println("FIELD:"+childElement.getFirstChild().getNodeValue());
						}
							
					}
					
				//------------------------------------------------------------------------------	
					
					if(book.getNodeName().equals("Success")){
						String success=book.getFirstChild().getNodeValue();
						System.out.println("Success:"+success);
					}
					if(book.getNodeName().equals("Time")){
						String time=book.getFirstChild().getNodeValue();
						System.out.println(time);
					}
					if(book.getNodeName().equals("Object")){
						if(p==0){
							System.out.println("ceshi:"+book.getAttributes().getNamedItem("xsi:type").getNodeValue());//当前的标签
							NodeList nl=book.getChildNodes();
							for(int j=0;j<nl.getLength();j++){
								Node childNode = (Node) nl.item(j);
								if (childNode.getNodeType() == Node.ELEMENT_NODE){
									Element childElement = (Element) childNode;
									String attrA = childElement.getTextContent();
								    System.out.println("what:"+attrA);
									//版本号
									if ("TerminalId".equals(childElement.getNodeName())){
										System.out.println(childElement.getFirstChild().getNodeValue());
									}
									if("TerminalName".equals(childElement.getNodeName())){
										System.out.println(childElement.getFirstChild().getNodeValue());
									}
									if("s".equals(childElement.getNodeName())){
										System.out.println(childElement.getFirstChild().getNodeValue());
									}
									if("ss".equals(childElement.getNodeName())){
										System.out.println(childElement.getFirstChild().getNodeValue());
									}
								}
							}		
						}
						p=1;
					}
					
				}
			}
		}
	}		
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		System.out.println("parseXML -------------Start");
		new ParseXML();
	}
	
}
