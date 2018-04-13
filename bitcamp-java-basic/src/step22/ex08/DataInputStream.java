// InputStream에 붙이는 플러그인(decorator)을 다른 플러그인에 붙이려면,
// 플러그인(decorator) 클래스도 InputStream의 가족이 되어야 한다.

package step22.ex08;


import java.io.IOException;
import java.io.InputStream;

//=> 이 상속은 기능을 상속 받기 위한 것이 아니다.
// 같은 그룹으로 묶이기 위함이다.
public class DataInputStream extends InputStream {

    InputStream in;
    
    public DataInputStream(InputStream in) throws Exception {
        this.in = in;
    }
    
    @Override
    public int read() throws IOException {
        return in.read();
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
    
    @Override
    public void close() throws IOException {
        in.close();
    }
}
