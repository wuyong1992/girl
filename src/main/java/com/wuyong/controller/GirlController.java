package com.wuyong.controller;

import com.wuyong.repository.GirlRepository;
import com.wuyong.pojo.Girl;
import com.wuyong.service.IGirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 坚果
 * on 2017/6/24
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private IGirlService iGirlService;

    /**
     * 查询女生列表
     *
     * @return
     */
    @RequestMapping(value = "getGirlList")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个girl
     *
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "addGirl")
    public Girl addGirl(@RequestParam(value = "cupSize", required = false, defaultValue = "A") String cupSize,
                        @RequestParam(value = "age", required = false, defaultValue = "18") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 获取一个女生
     *
     * @param id 女生id
     * @return
     */
    @RequestMapping(value = "getGirl")
    public Girl getGirlById(@RequestParam(value = "id", required = true) Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     *
     * @param id 女生id
     * @return
     */
    @RequestMapping(value = "updateGirl")
    public Girl updateGirlById(@RequestParam(value = "id", required = true) Integer id,
                               @RequestParam(value = "cupSize", required = false) String cupSize,
                               @RequestParam(value = "age", required = false) Integer age) {
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delGirl")
    public Boolean delGirlById(@RequestParam(value = "id", required = true) Integer id) {
        Boolean flag = true;
        girlRepository.delete(id);
        if (girlRepository.findOne(id) != null) {
            flag = false;
        }
        return flag;
    }

    /**
     * 查找年龄段的女生
     *
     * @param firstAge
     * @param secondAge
     * @return
     */
    @RequestMapping(value = "findGirListBetweenAge")
    public List<Girl> findGirlListBetweenAge(Integer firstAge, Integer secondAge) {
        return girlRepository.findByAgeBetween(firstAge, secondAge);
    }

    @RequestMapping(value = "insert2")
    public void insert2(){
        iGirlService.insert2();
    }

}
