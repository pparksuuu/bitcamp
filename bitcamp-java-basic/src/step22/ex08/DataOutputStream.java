// OutputStream에 붙이는 플러그인(decorator)을 다른 플러그인에 붙이려면,
// 플러그인(decorator) 클래스도 OutputStream의 가족이 되어야 한다.
package step22.ex08;

import java.io.IOException;
import java.io.OutputStream;

//=> 이 상속은 기능을 상속 받기 위한 것이 아니다.
//같은 그룹으로 묶이기 위함이다.
public class DataOutputStream extends OutputStream {

    OutputStream out;
    public DataOutputStream(OutputStream out) throws Exception {
        this.out = out;
    }
    
    public void writeUTF(String str) throws Exception {
        byte[] bytes = str.getBytes("UTF-8");
        out.write(bytes.length);
        out.write(bytes);
    }
    
    public void writeInt(int value) throws Exception {
        out.write(value >> 24);
        out.write(value >> 16);
        out.write(value >> 8);
        out.write(value);
    }
    
    public void writeLong(long value) throws Exception {
        out.write((int)(value >> 56));
        out.write((int)(value >> 48));
        out.write((int)(value >> 40));
        out.write((int)(value >> 32));
        out.write((int)(value >> 24));
        out.write((int)(value >> 16));
        out.write((int)(value >> 8));
        out.write((int)value);
    }
    
    public void writeBoolean(boolean value) throws Exception {
        if (value)
            out.write(1);
        else
            out.write(0);
    }
    
    @Override
    public void close() throws IOException {
        out.close();
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

}
