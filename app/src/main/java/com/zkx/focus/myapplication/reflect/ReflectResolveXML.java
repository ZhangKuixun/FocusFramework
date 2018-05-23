package com.zkx.focus.myapplication.reflect;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Stack;

public class ReflectResolveXML extends DefaultHandler {
    public static final String T_COLLECTION = "collection";
    public static final String T_OBJECT = "object";
    public static final String T_LANG = "lang";
    private static final String T_DATE = "date";
    private static final String D_PATTERN = "yyyy-MM-dd HH:mm:ss";
    Stack<Object> stack = new Stack<Object>();
    private Object root = null;

    public Object getRoot() {
        return root;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        //  System.out.println("endElement:"+uri+" localName:"+localName+ " qName:"+qName);
        if (qName.equals(T_OBJECT) || qName.equals(T_COLLECTION)) {
            //如果集合类或者object类 属性注入完成则需要弹出堆栈  
            stack.pop();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < attributes.getLength(); i++) {
            stb.append(attributes.getValue(i) + "---");
        }
        System.out.println("startElement:" + uri + " localName:" + localName + " qName:" + qName + " Attr: " + stb.toString());
        //如果根元素为null  则新建一个 因为第一个读取的必定是根元素  
        String type = attributes.getValue("type");
        if (root == null) {
            root = instanceObjectByType(type);
            stack.push(root);
            return;
        }
        String value = attributes.getValue("value");
        String name = attributes.getValue("name");
        Object pObj = stack.peek();
        //根元素不为空 则根据 qname判断
        if (qName.equals(T_COLLECTION) || qName.equals(T_OBJECT)) {
            //如果是list则new 一个list 或者 object 则new出来
            Object obj = instanceObjectByType(type);
            stack.push(obj);
            injectToParent(pObj, obj, name);
        } else if (qName.equals(T_LANG)) {
            //如果是lang 则需要转化value值
            Object valueObj = typeConvert(type, value);
            injectToParent(pObj, valueObj, name);
        } else if (qName.equals(T_DATE)) {
            //如果是date
            String pattern = attributes.getValue("pattern");
            if (pattern == null) {
                pattern = D_PATTERN;
            }
            Object valueObj = typeConvertDate(value, pattern);
            injectToParent(pObj, valueObj, name);
        }
    }


    //转化date类型  
    private Date typeConvertDate(String value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sdf.parse(value);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //向上一级元素中注入属性 或者向集合类中add子元素  
    private void injectToParent(Object pObj, Object fieldValue, String fieldName) {
        if (pObj instanceof Collection) {
            //如果上一级是集合类 则需要添加进去  
            ((Collection) pObj).add(fieldValue);
            return;
        }
        //如果上一级是object 则需要反射字段赋值  
        Field[] fields = pObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                try {
                    field.setAccessible(true);
                    field.set(pObj, fieldValue);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    //反射实例化对象  
    private Object instanceObjectByType(String qName) {
        try {
            Class localClass = Class.forName(qName);
            Object obj = localClass.getConstructor().newInstance();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    // 此方法用于将一个字符串转换为相应的数据类型  
    public Object typeConvert(String className, String value) {
        if (className.equals("java.lang.String")) {
            return value;
        } else if (className.equals("java.lang.Integer")) {
            return Integer.valueOf(value);
        } else if (className.equals("java.lang.Long")) {
            return Long.valueOf(value);
        } else if (className.equals("java.lang.Boolean")) {
            return Boolean.valueOf(value);
        } else if (className.equals("java.lang.Float")) {
            return Float.valueOf(value);
        } else if (className.equals("java.lang.Double")) {
            return Double.valueOf(value);
        } else
            return null;
    }


}