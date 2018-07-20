package com.da.springbootdemo1.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@Service
public class RedisDao {
    @Autowired
    private StringRedisTemplate srt;

    public String getObject(String string) {
        return srt.opsForValue().get(string);
    }

    /**
     * 在redis中设置参数
     * @param key
     * @param value
     * @param time
     */
    public void setObject(String key, Object value, Long time) {
        if (key != null && !key.isEmpty() && value != null) {
            if (value instanceof String) {
                String vv = (String) value;
                if (time == null) {
                    srt.opsForValue().set(key, vv);
                } else {
                    srt.opsForValue().set(key, vv, time, TimeUnit.SECONDS);
                }
                return;
            }

            if (value instanceof List) {
                List<String> vv = (List<String>) value;
                for (String s : vv) {
                    if (time == null) {
                        srt.opsForList().leftPush(key, s);
                    }
                }
                return;
            }

            if (value instanceof Set) {
                Set<String> vv = (Set<String>) value;
                for (String s : vv) {
                    srt.opsForSet().add(key, s);
                }
                return;
            }

            if (value instanceof Map) {
                Map<String, String> vv = (Map<String, String>) value;
                srt.opsForHash().putAll(key, vv);
                return;
            }
        } else {
            throw new RuntimeException();
        }
    }
}
