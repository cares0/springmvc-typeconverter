package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService() {

        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 사용
        Integer result1 = conversionService.convert("10", Integer.class);
        Assertions.assertThat(result1).isEqualTo(10);

        String result2 = conversionService.convert(10, String.class);
        Assertions.assertThat(result2).isEqualTo("10");

        IpPort result3 = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(result3).isEqualTo(new IpPort("127.0.0.1", 8080));

        String result4 = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        Assertions.assertThat(result4).isEqualTo("127.0.0.1:8080");
    }
}
