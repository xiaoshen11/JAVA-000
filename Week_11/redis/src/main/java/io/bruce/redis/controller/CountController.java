package io.bruce.redis.controller;

import io.bruce.redis.service.RedisCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/count")
public class CountController {

    @Autowired
    private RedisCount redisCount;

    @PostMapping("incr")
    public String incr(@RequestParam("key") String key){
        redisCount.incr(key);
        return redisCount.get(key);
    }

}
