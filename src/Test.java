import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by bobi on 2018/8/24.
 */
public class Test {

    public static void main(String[] args) {
        P p = new P();
        Integer num = p.getI();
    }

}

class P {
    Integer i;
    Long l;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }
}