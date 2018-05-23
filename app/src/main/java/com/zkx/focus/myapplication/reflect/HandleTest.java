package com.zkx.focus.myapplication.reflect;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * 使用
 * String s = getApplicationContext().getPackageResourcePath() + "/files/" + "reflect.xml";
 * HandleTest handleTest = new HandleTest();
 * try {
 * handleTest.testresolveXmlTest(s);
 * } catch (ParserConfigurationException e) {
 * e.printStackTrace();
 * } catch (SAXException e) {
 * e.printStackTrace();
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 */
public class HandleTest {

    public void testresolveXmlTest(String s) throws ParserConfigurationException, SAXException, IOException {
        //  HttpDownloader downloader=new HttpDownloader();
        //  String xml= downloader.download(Mp3ListActiviy.URL);

//        File file = new File("../../../../../res/layout");

        File file = new File("./app/src/main/res/raw/reflect.xml");
//        File file = new File(s);
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        ReflectResolveXML reflectResolveXML = new ReflectResolveXML();
        saxParser.parse(file, reflectResolveXML);

        System.out.println("---------------------");

        List<Resource> resources = (List<Resource>) reflectResolveXML.getRoot();
        for (Resource resource : resources) {
            System.out.println(resource.toString());
        }
        //mp3xmlHandle.getMp3List();
    }
}