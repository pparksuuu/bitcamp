// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam11_1") 
public class Exam11_1 {

    @Autowired ServletContext sc;

    @PostMapping("upload01")
    public void upload01(
            String name, 
            int age,
            MultipartFile[] files,
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);

        String filesDir = sc.getRealPath("/files");  // 진짜 Real Path (사진이 저장되는 폴더명)

        int i = 0;
        for (MultipartFile file : files) {
            // file에 대해 original File명과 새 파일을 구분하기 위해서
            String filename = UUID.randomUUID().toString();
            model.addAttribute("file" + i + "Original", file.getOriginalFilename());
            model.addAttribute("file" + i + "New", filename);
            i++;
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                file.transferTo(path); // 거기에 새 파일 이름을 붙임.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}







