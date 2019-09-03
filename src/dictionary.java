import java.io.*;
import java.util.HashMap;

public class dictionary {
    static HashMap<String,String> dic = new HashMap<String,String>();

    public void initiateDic(String dicPath){
        File filename = new File(dicPath);
        InputStreamReader reader = null; // 建立一个输入流对象reader
        try {
            reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String slot = "";
            slot = br.readLine();
            while (slot != null) {
                String[] keyValue = slot.split(" ");
                dic.put(keyValue[0],keyValue[1]);
                slot = br.readLine(); // 一次读入一行数据
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // TODO: 2019/9/3
        } catch (IOException e){
            e.printStackTrace();
            // TODO: 2019/9/3
        }


    }
    public String add(String key,String value){
        String output = "";
        if(dic.get(key) == null){
            // TODO: 2019/9/3  concurrency
            dic.put(key,value);
            output = "Added successfully";
        }else{
            output = "Key already exists";
        }
        return output;
    }
    public String query(String key){
        String output = "";
        if(dic.get(key) == null){
            // TODO: 2019/9/3  concurrency
            output = "Key not exists";
        }else{
            output = dic.get(key);
        }
        return output;
    }
    public String remove(String key){
        String output = "";
        if(dic.get(key) == null){
            // TODO: 2019/9/3  concurrency
            output = "Key not exists";
        }else{
            // TODO: 2019/9/3  concurrency
            output = dic.get(key);
        }
        return output;
    }

}
