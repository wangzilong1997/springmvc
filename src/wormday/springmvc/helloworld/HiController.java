package wormday.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wormday.springmvc.object.User;
import wormday.springmvc.object.admin;

@Controller
@RequestMapping("/hi")
public class HiController {
    @RequestMapping("/say")
    public String say() {
        System.out.println("say.jsp访问");
        return "index";
    }

    @RequestMapping(value = "baseType.do")
    @ResponseBody
    public String baseType(@RequestParam(value = "xage") int age){
        return "Int age:" + age;
    }

    @RequestMapping(value = "baseType2.do")
    @ResponseBody
    public String baseType2(Integer age){
        return "Integer age:" + age;
    }

    //http://localhost:8080/hi/array.do?name=miaoge&name=qiange&name=wuge
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for(String item : name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //http://localhost:8080/hi/object.do?name=Tom&age=10
    //http://localhost:8080/hi/object.do?name=Tom&age=10&contactInfo.phone=111111&contactInfo.address=%22hebei%22
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user){
        return user.toString();
    }
    //http://localhost:8080/hi/object2.do?admin.name=%22wang%22&User.name=%22zhang%22&age=666
    @RequestMapping(value = "object2.do")
    @ResponseBody
    public String object(User user, admin admin){
        return user.toString()+ " " +admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("User.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }
}