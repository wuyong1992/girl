package com.wuyong.service.impl;

import com.wuyong.repository.GirlRepository;
import com.wuyong.pojo.Girl;
import com.wuyong.service.IGirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 坚果
 * on 2017/6/24
 */
@Transactional
@Service("iGirlService")
public class GirlServiceImpl implements IGirlService {

    @Autowired
    private GirlRepository girlRepository;


    public void insert2(){
        Girl girl1 = new Girl();
        Girl girl2 = new Girl();
        girl1.setAge(25);
        girl1.setCupSize("B");
        girl2.setAge(26);
        girl2.setCupSize("C");

        girlRepository.save(girl1);
        girlRepository.save(girl2);
    }


}
