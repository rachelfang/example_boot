package com.example.demo.Web;

import com.example.demo.domain.Hello;
import com.example.demo.domain.NameEntity;
import com.example.demo.service.NameService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by fangjing on 2019/1/15.
 */


@RestController
public class HelloController {

    @Autowired
    NameService nameService;

    private static final String template = "Hello, %s!";
    private static final String template1 = "Hello post, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/testgreeting")
    public Hello hello(@RequestParam(value="name", defaultValue="World") String name, @RequestParam(value="content", defaultValue = "test") String content) {
        /*
        * 参数传递使用get 方式
        * postman data：
        *   http://localhost:8080/testgreeting?name=fang&content=happy
        * */
        return new Hello(counter.incrementAndGet(), String.format(template, name), content);
    }

    @RequestMapping("/getname")
    public String getName(@RequestParam(value="name", defaultValue = "hello") String name, @RequestParam(value="content", defaultValue = "test") String content)
    {
        /*
        * get 传参
        * 使用默认值
        * */
        Hello hel = new  Hello(counter.incrementAndGet(), name,content);
        return hel.getName();

    }

    @RequestMapping("/test")
    public String test()
    {
        /*无参数传递
        * postman data:
        * url: http://localhost:8080/test
        * */
        return "hello";
    }


    @RequestMapping(value="/testpost", method = RequestMethod.POST)
    public String testHello(@RequestBody NameEntity input)
    {
        /*
         使用RequestBody 传递参数
        postmandata:
        {
	        "name" : "Google",
	        "surname": "test",
	        "age": 18
        }
        body: 选择 raw -json
        */
        return String.format(template1, input.getName());
    }

    @RequestMapping(value="/postpara", method= RequestMethod.POST)
    public String testPostpara(@RequestParam(value="name") String name)
    {
        /*
        postman:使用 [x-www-form-urlencoded]
         */
        return String.format(template1, name);
    }


    @RequestMapping(value="/findall")
    @ResponseBody
    public List<NameEntity> findAll()
    {
        /*
        * postmandata:
        * http://localhost:8080/findall
        * */
        List<NameEntity> nameEntities = (List<NameEntity>) nameService.findAll();
        return nameEntities;
    }

    @RequestMapping(value="/pathvariable/{id}")
    public String testPathVariable(@PathVariable("id") int id)
    {
        /*
        * postmandata:
        * http://localhost:8080//pathvariable/2
        * */
        System.out.println(id);
        return String.format("test path variable, id:%s", id);
    }


}

