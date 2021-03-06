package config.create;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

public class RMappp {

    public static void main(String[] args) {
        // 默认连接上127.0.0.1:6379
        RedissonClient client = Redisson.create();
        // RMap 继承了 java.util.concurrent.ConcurrentMap 接口
        RMap<String, String> map = client.getMap("personalInfo");
        map.put("name", "yanglbme");
        map.put("address", "Shenzhen");
        map.put("link", "https://github.com/yanglbme");

        boolean contains = map.containsKey("link");
        System.out.println("Map size: " + map.size());
        System.out.println("Is map contains key 'link': " + contains);
        String value = map.get("name");
        System.out.println("Value mapped by key 'name': " + value);
        boolean added = map.putIfAbsent("link", "https://doocs.github.io") == null;
        System.out.println("Is value mapped by key 'link' added: " + added);
        client.shutdown();
    }

}
