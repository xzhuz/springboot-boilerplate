package fun.baozi.web.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Strings;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;


/**
 * lettuce配置 异步.
 *
 * @author meisen
 * 2020-08-06
 */
//@Configuration
public class LettuceConfig {

    private final RedisProperties redisProperties;

    @Autowired
    public LettuceConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }


    @Bean(destroyMethod = "shutdown")
    public ClientResources clientResources() {
        return DefaultClientResources.create();
    }

    @Bean(destroyMethod = "shutdown")
    public RedisClient redisClient(ClientResources clientResources) {
        RedisURI.Builder builder = RedisURI.builder()
                .withHost(redisProperties.getHost())
                .withPort(redisProperties.getPort())
        // .withTimeout(redisProperties.getTimeout())
                .withDatabase(0);
        String password = redisProperties.getPassword();
        if (!Strings.isNullOrEmpty(password)) {
            builder.withPassword(password);
        }
        return RedisClient.create(clientResources, builder.build());
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisConnection connection(RedisClient redisClient) {
        return redisClient.connect();
    }
}
