package IO;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class File文件类 {

    @Test
    public void test() {
        //构造器1
        File file1 = new File("hello.txt");//相对于module（java_senior）的相对路径
        System.out.println(file1);

        //构造器2:代表目录
        File file2 = new File("/home/sheldon13/Desktop/Code/java/helloworld/src/com/helloworld/", "java");
        System.out.println(file2);

        //构造器3：以file2的目录里面的文件
        File file3 = new File(file2, "helloworld.java");
        System.out.println(file3);
    }

    @Test
    public void test2() {
        File file1 = new File("helloworld.java");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.length());//大小
        System.out.println(file1.lastModified());
    }

    //目录方法
    @Test
    public void test3() {
        //获得目录下所有文件的名字
        File file = new File("/home/sheldon13/Desktop/Code/java/");
        String[] list = file.list();
        for (String e : list) {
            System.out.println(e);
        }

        //获得目录下所有文件的对象
        File[] files = file.listFiles();
        for (File f:files){
            System.out.println(f);
        }

    }

    //重命名:file1改称file2,file1必须存在
    @Test
    public void test4() {
        File file1= new File("5464");
        File file2= new File("hello.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    //判断
    @Test
    public void test5() {
        File file1= new File("hello.txt");
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.canWrite());
        System.out.println(file1.canRead());
        System.out.println(file1.isHidden());
    }

    //创建：由内存中的对象去创建硬盘中真正的文件
    @Test
    public void test6() throws IOException {
        //文件创建
        File file = new File("hi.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建 ok");
        }else {
            file.delete();
            System.out.println("删除");
        }

        //目录创建
        File dir = new File("/home/sheldon13/Desktop/testtt/rrr/sss");
        System.out.println(dir.mkdir());//上级目录必须存在，否则失败
        System.out.println(dir.mkdirs());//上级目录可以不存在
    }


}
