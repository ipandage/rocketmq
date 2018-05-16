package mappedbyte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;


/**
 *
 * 内存映射文件进行读写：速度大于缓冲区读写，字节流读写，随机文件读写
 * 由于是硬盘文件的内存映射，所以一旦修改内容，等同修改文件内容，所以适宜读取文件
 *
 */
public class MappedByteBuffer01 {


    public static void main(String[] args) {

        //定义文件操作目录
        File read = new File("/Users/admin/Downloads/read.txt");

        //定义读写流，通道
        FileInputStream in = null;
        FileChannel fin = null;


        try {

            in = new FileInputStream(read);
            fin = in.getChannel();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //声明内存映射
        MappedByteBuffer map = null;


        try {
            //通过通道获取内存映射
            map = fin.map(MapMode.READ_ONLY, 0, read.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将存映射放入到变量中进行输出
        byte [] data = new byte[(int) read.length()];
        int foot = 0;

        while(  map.hasRemaining()){
            data[foot++] = map.get();
        }
        try {
            System.out.println(new String(data,"GB2312"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

// 其他参考 https://www.jianshu.com/p/f90866dcbffc
