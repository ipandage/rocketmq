package commonscli;

import org.apache.commons.cli.ParseException;

/**
 * @author gxg
 * @date 2018/5/10 下午4:24
 */
public class TestCli {
    public static void main(String[] args) throws ParseException {
        String argss[]={"-t 1000"};
        // String argss[]={"-h"};
        CLI.main(argss);
    }
}
