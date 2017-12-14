package nicetry.instrument;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Read <T>{
    private List<T> listData;
    private Class<T> tClass;
    private String className;
    public List<T> getDataForXml(Class<T> tClass,String path)throws Exception{
        listData = new ArrayList<>();
        this.tClass = tClass;
        String[] split = tClass.getName().split("\\.");
        this.className = split[split.length - 1];
        getMessage(path);
        return listData;
    }

    private void getMessage( String path) throws Exception{
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new File(path));
            all(document.getRootElement());
        }catch (DocumentException e) {
            throw new RuntimeException("文件未找到");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void all(Element element) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T t = tClass.newInstance();
        List<Attribute> attributes = element.attributes();
        for (int i = 0; i < attributes.size(); i++) {
            if (className.equalsIgnoreCase(element.getName()) && judge(attributes.get(i))){
                t = add(attributes.get(i),t);
            }
        }
        List<Element> elements = element.elements();
        for (int i = 0; i < elements.size(); i++) {
            if (className.equalsIgnoreCase(element.getName()) && judge(elements.get(i))){
                t = add(elements.get(i),t);
            }
            all(elements.get(i));
        }
        if (className.equalsIgnoreCase(element.getName()))
        listData.add(t);
    }

    private boolean judge(Element element){
        Field[] fields = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(element.getName().trim())) {
                return true;
            }
        }
        return false;
    }
    private boolean judge(Attribute element){
        Field[] fields = tClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(element.getName().trim())) {
                return true;
            }
        }
        return false;
    }
    private T add(Element element ,T o) throws NoSuchFieldException, IllegalAccessException {
            Field declaredField = tClass.getDeclaredField(element.getName().trim());
            declaredField.setAccessible(true);
            declaredField.set(o, element.getText().trim());
        return o;
    }
    private  T add(Attribute element , T o) throws NoSuchFieldException, IllegalAccessException {
            Field declaredField = tClass.getDeclaredField(element.getName().trim());
            declaredField.setAccessible(true);
            declaredField.set(o,element.getText().trim());
        return o;
    }
}
