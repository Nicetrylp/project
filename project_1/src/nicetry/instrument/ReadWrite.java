package nicetry.instrument;

import nicetry.bean.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWrite {
    public static Map<String, User> Read() throws DocumentException {
        // 创建一个Map表,保存从xml取出的person
        Map<String, User> map = new HashMap<>();
        // 创建一个reader对象
        SAXReader reader = new SAXReader();
        // 通过reader对象找到document对象
        Document document = reader.read(new File("src//Data.xml"));
        // 获取根标签    DATA
        Element rootElement = document.getRootElement();
        // 获取下一级标签  person
        List<Element> elements = rootElement.elements();
        // 遍历所有标签             person
        for (int i = 0; i < elements.size(); i++) {
            // 获取标签中的所有内容           已知内容形式
            Element userName = elements.get(i).element("userName");
            Element password = elements.get(i).element("password");
            Element name = elements.get(i).element("name");
            map.put(userName.getText(),new User(userName.getText(),password.getText(),name.getText()));
        }
        return map;
    }

    public static void Write(User person) throws DocumentException,IOException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src//Data.xml"));
        // 获取根标签
        Element rootElement = document.getRootElement();
        // 在根标签下写入子标签person
        Element person1 = rootElement.addElement("User");
        // 写完其他属性
        Element userName = person1.addElement("userName");
        Element password = person1.addElement("password");
        Element name = person1.addElement("name");
        userName.addText(person.getUserName());
        password.addText(person.getPassword());
        name.addText(person.getName());
        // 修改编码格式
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        // 创建xml文件
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src//Data.xml"),outputFormat);
        // 将doc写入xml中
        xmlWriter.write(document);
        // 关闭xml文件
        xmlWriter.close();
    }
}
