// DataInputStream을 FileInputStream이나 ByteArrayInputStream에 붙일 수 있도록
// 기능을 변경한다. 죽  DataInputStream을 장신구(decorator)로 만든다.
package step22.ex08;


import java.io.InputStream;

public class DataInputStream {

    InputStream in;
    
    public DataInputStream(InputStream in) throws Exception {
        this.in = in;
    }
    
    public String readUTF() throws Exception {
        int size = in.read();
        byte[] bytes = new byte[size];
        in.read(bytes);
        return new String(bytes, "UTF-8");
    }
    
    public int readInt() throws Exception {
        int value = 0;
        value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        return value;
    }
    
    public long readLong() throws Exception {
        long value = 0;
        value = (long)in.read() << 56;
        value += (long)in.read() << 48;
        value += (long)in.read() << 40;
        value += (long)in.read() << 32;
        value += (long)in.read() << 24;
        value += (long)in.read() << 16;
        value += (long)in.read() << 8;
        value += (long)in.read();
        return value;
    }
    
    public boolean readBoolean() throws Exception {
        if (in.read() == 1)
            return  true;
        else
            return false;
        
    }
    
    public void close() throws Exception {
        in.close();
    }
}
