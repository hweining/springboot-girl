package com.imooc.girl.controller;

import com.imooc.girl.Girl;
import com.imooc.girl.GirlRepository;
import com.imooc.girl.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("我是girlList方法");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age,
                        @RequestParam("name") String name){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setName(name);
        return girlRepository.save(girl);
    }
    /**
     * 查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }


    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdateOne(@PathVariable("id") Integer id,
                              @RequestParam("cupSize") String cupSize,
                              @RequestParam("age") Integer age,
                              @RequestParam("name") String name) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        girl.setName(name);
        return girlRepository.save(girl);
    }

    /**
     * 通過id刪除
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDeleteOne(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

   /**
    * 通過名字查詢
     * @param name
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/name/{name}")
    public List<Girl> girlFindByName(@PathVariable("name") String name) {
        return girlRepository.findByName(name);
    }

    /**
     * 通過年齡查詢
     * @param age
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 通過罩杯查詢
     * @param cupSize
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/cupSize/{cupSize}")
    public List<Girl> girlFindByCupSize(@PathVariable("cupSize") String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    /**
     * 通過金額查詢
     * @param money
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/money/{money}")
    public List<Girl> girlFindByMoney(@PathVariable("money") Double money){
        return girlRepository.findByMoney(money);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }



}
