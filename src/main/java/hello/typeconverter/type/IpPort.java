package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// ip + port로 요청이 오면, 각각 파싱해서 멤버에 담을 예정
@Getter
@EqualsAndHashCode
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
