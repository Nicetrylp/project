package com.lanou3g.study;

import com.lanou3g.instrument.UserInstrument;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class T {
    @Test
    public void t1() throws SQLException {
        UserInstrument.query();
    }
    @Test
    public void t2() throws SQLException {
        UserInstrument.drop("zhangSan");
    }
    @Test
    public void t3() throws SQLException {
        UserInstrument.update("zhangSan","地球",50,32);
    }
    @Test
    public void t4() throws SQLException {
        UserInstrument.add("张三","南京",13);
    }
}
