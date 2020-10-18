package jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> clz = new HelloClassLoader().findClass("Hello");

            Method hello = clz.getMethod("hello");
            hello.setAccessible(true);

            hello.invoke(clz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        File file = new File("D:\\project\\test\\src\\main\\java\\jvm\\Hello.xlass");
        int length = (int)file.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(file).read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte)(255 - bytes[i]);
        }
        return defineClass(name,bytes,0,length);
    }


}
