package cn.gsq.queryform.dao;

import cn.gsq.queryform.domain.XS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author diao 2021/2/25
 */
@Mapper
public interface XSDao {

    @Select("SELECT  CUST_ID AS 客户ID ,\n" +
            "        CUST_NAME AS 客户名称 ,\n" +
            "        CO_NUMBER AS 订单号 ,\n" +
            "        CO_LN_NO AS 行号 ,\n" +
            "        ITEM AS 料号 ,\n" +
            "        ITEM_DESC AS 描述 ,\n" +
            "        LN_STA AS 订单状态 ,\n" +
            "        ORDER_QTY AS 订单数量 ,\n" +
            "        ISSUED_QTY AS PICK数量 ,\n" +
            "        ORDER_QTY - ISSUED_QTY AS PICK数量小于订单数量 ,\n" +
            "        TOT_SHPPED AS SHIP数量 ,\n" +
            "        ISSUED_QTY - TOT_SHPPED AS 未SHIP数量 ,\n" +
            "        --UNIT_PRICE AS 单价 ,\n" +
            "        CURR_CODE AS 货币代码 ,\n" +
            "        CONVERT(CHAR(10), REQD_DATE, 120) AS 交货日期,\n" +
            "        CONVERT(CHAR(10), getdate(), 120) as 当前时间,\n" +
            "        DATEDIFF(DAY,CONVERT(CHAR(10), REQD_DATE, 120),CONVERT(CHAR(10), getdate(), 120)) as 超出天数\n" +
            "FROM    ORDER_CUSTOMERDETAIL2\n" +
            "WHERE   ISSUED_QTY - TOT_SHPPED <> 0\n" +
            "order by DATEDIFF(DAY,CONVERT(CHAR(10), REQD_DATE, 120),CONVERT(CHAR(10), getdate(), 120)) desc")
    public List<XS> findAll();
}
