package fun.baozi.mybatis;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baozi
 * @date 2020-07-03
 */
public class MapperGeneratorTest {

    @Test
    public void testGenerator() {
        try {
            List<String> warnings = new ArrayList<>();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(MapperGeneratorTest.class.getResourceAsStream("/generatorConfig.xml"));
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
