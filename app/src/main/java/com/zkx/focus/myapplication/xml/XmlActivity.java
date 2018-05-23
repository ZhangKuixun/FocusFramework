package com.zkx.focus.myapplication.xml;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;

import com.zkx.focus.myapplication.R;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;

public class XmlActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fileName = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            fileName = Environment.getExternalStorageDirectory()
                    + "/poem.xml";
        } else {
            fileName += "/poem.xml";
        }
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fos = new FileOutputStream(f);
            XmlSerializer serializer = Xml.newSerializer();
            //设置文件输出位置
            serializer.setOutput(fos, "utf-8");
            //开始xml声明，这个方法必须在setOutput（）方法之后调用
            serializer.startDocument(null, true);
            //开始poem标签
            serializer.startTag(null, "poem");
            //设置lang属性，这里有一点需要注意，serializer始终代表上一个tag，所以不用声明多个serializer
            serializer.attribute(null, "lang", "chinese");
            serializer.startTag(null, "title");
            //
            serializer.text("静夜思");
            serializer.endTag(null, "title");
            serializer.startTag(null, "author");
            serializer.text("李白");
            serializer.endTag(null, "author");
            serializer.startTag(null, "content");
            serializer.text("床前明月光，疑是地上霜，举头望明月，低头思故乡");
            serializer.endTag(null, "content");
            serializer.endDocument();
            serializer.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
